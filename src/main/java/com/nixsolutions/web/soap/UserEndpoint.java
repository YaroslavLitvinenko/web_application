package com.nixsolutions.web.soap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.nixsolutions.spring.model.db.entity.Role;
import com.nixsolutions.spring.model.db.entity.User;
import com.nixsolutions.spring.model.service.RoleServ;
import com.nixsolutions.spring.model.service.UserServ;


@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://localhost:8080/spring/ws/soap/user";

    @Autowired
    UserServ userServ;

    @Autowired
    RoleServ roleServ;

    @PayloadRoot (namespace = NAMESPACE_URI, localPart = "createUserRequest")
    @ResponsePayload
    public CreateUserResponse createUser(@RequestPayload CreateUserRequest request) {
        String nickname = request.getNickname();
        String password = request.getPassword();
        String[] roles = request.getRoles().split("_");
        
        ArrayList<Role> listRoles = new ArrayList<>();
        for (String role : roles) {
        	listRoles.add(roleServ.findByName(new Role(role)));
        }
        
        User user = new User(nickname, password);
        user.setRoles(listRoles);
        user = userServ.createRecord(user);

        CreateUserResponse response = new CreateUserResponse();
        response.setUserID(user.getUserID());
        return response;
    }

    @PayloadRoot (namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUser(@RequestPayload UpdateUserRequest request) {
        Long userID = request.getUserID();
        String nickname = request.getNickname();
        String password = request.getPassword();
        String[] roles = request.getRoles().split("_");

        ArrayList<Role> listRoles = new ArrayList<>();
        for (String role : roles) {
        	listRoles.add(roleServ.findByName(new Role(role)));
        }
        
        User user = new User(userID, nickname, password);
        user.setRoles(listRoles);
        userServ.updateRecord(user);

        UpdateUserResponse response = new UpdateUserResponse();
        response.setUserID(user.getUserID());
        response.setNickname(user.getNickname());
        response.setPassword(user.getPassword());
        response.setRoles(request.getRoles());
        return response;
    }
}
