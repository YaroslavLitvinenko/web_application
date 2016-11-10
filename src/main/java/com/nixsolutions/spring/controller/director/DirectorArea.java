package com.nixsolutions.spring.controller.director;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nixsolutions.spring.model.db.entity.Admin;
import com.nixsolutions.spring.model.service.AdminServ;
import com.nixsolutions.spring.model.service.UserServ;

@Controller
public class DirectorArea {
	@Autowired
	UserServ userServ;
	@Autowired
	AdminServ adminServ;
	
	@RequestMapping(value = "director_area", method = RequestMethod.GET)
	public String getList(Model model) {
		model.addAttribute("listAdmin", adminServ.findAll());
		
		return "direct_area";
		
	}
	
	@RequestMapping(value = "director_area", method = RequestMethod.POST)
	public String delete(Model model, @ModelAttribute("action") String parameter) {
		adminServ.delete(new Admin(Long.parseLong(parameter)));
		
		return getList(model);
	}
}
