package com.nixsolutions.spring.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nixsolutions.spring.model.db.entity.Client;
import com.nixsolutions.spring.model.service.ClientServ;
import com.nixsolutions.spring.model.service.UserServ;

@Controller
public class ClientArea {
	@Autowired
	ClientServ clientServ;
	@Autowired
	UserServ userServ;
	
	@RequestMapping(value = "client_area", method = RequestMethod.GET)
	public String getName(Model model) {
		User userInSystem = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Client client = new Client(userServ.findRecordByLogin(
				new com.nixsolutions.spring.model.db.entity.User(userInSystem.getUsername())));
		client = clientServ.findByUserID(client);
		
		model.addAttribute("client", client);
		
		return "clientArea";
	}
}
