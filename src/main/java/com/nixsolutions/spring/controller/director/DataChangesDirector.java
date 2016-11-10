package com.nixsolutions.spring.controller.director;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nixsolutions.spring.model.db.entity.Admin;
import com.nixsolutions.spring.model.db.entity.Role;
import com.nixsolutions.spring.model.db.entity.User;
import com.nixsolutions.spring.model.service.AdminServ;
import com.nixsolutions.spring.model.service.RoleServ;
import com.nixsolutions.spring.model.service.UserServ;

@Controller
public class DataChangesDirector {
	@Autowired
	AdminServ adminServ;
	@Autowired
	RoleServ roleServ;
	@Autowired
	UserServ userServ;
	
	@RequestMapping(value = "data_variation_d", method = RequestMethod.GET)
	public String getForm(Model model, @ModelAttribute("action") String parameter) {
		String[] comand = parameter.split("_");
		if (comand[0].equals("upd")) {
			Admin admin = new Admin(Long.parseLong(comand[1]));
			admin = adminServ.findByID(admin);
			
			model.addAttribute("admin", adminServ.findByID(admin));
			
			return "data/admin_data";
		} else if (comand[0].equals("new")) {
			model.addAttribute("admin", new Admin());
			
			return "data/admin_data";
		} else {
			throw new RuntimeException("Comand not found!");
		}
	}
	
	@RequestMapping(value = "data_variation_d", method = RequestMethod.POST)
	public String processingForm(HttpServletRequest request, @ModelAttribute("admin") Admin admin) {
		String[] roles = request.getParameterValues("role");
		
		List<Role> listRoles = new ArrayList<>();
		for (String role : roles)
			listRoles.add(roleServ.findByName(new Role(role)));
		
		if (admin.getAdminID() == null) {
			admin.getUser().setRoles(listRoles);
			
			adminServ.save(admin);
		} else {
			Admin adminInBD = adminServ.findByID(admin);
			User user = new User(adminInBD.getUser().getNickname());
			user = userServ.findRecordByLogin(user);
			user.setNickname(admin.getUser().getNickname());
			user.setPassword(admin.getUser().getPassword());
			user.setRoles(listRoles);
			admin.setUser(user);
			
			adminServ.update(admin);
		}
		
		return "redirect:/director_area";
		
	}
}
