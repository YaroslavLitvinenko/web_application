package com.nixsolutions.spring.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nixsolutions.spring.model.db.entity.Author;
import com.nixsolutions.spring.model.db.entity.Book;
import com.nixsolutions.spring.model.db.entity.Category;
import com.nixsolutions.spring.model.db.entity.Cell;
import com.nixsolutions.spring.model.db.entity.Client;
import com.nixsolutions.spring.model.service.AuthorServ;
import com.nixsolutions.spring.model.service.BookServ;
import com.nixsolutions.spring.model.service.CategoryServ;
import com.nixsolutions.spring.model.service.CellServ;
import com.nixsolutions.spring.model.service.ClientServ;
import com.nixsolutions.spring.model.service.JournalServ;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminArea {
	@Autowired
	private CategoryServ categoryServ;
	@Autowired
	private BookServ bookServ;
	@Autowired
	private CellServ cellServ;
	@Autowired
	private ClientServ clientServ;
	@Autowired
	private JournalServ journalServ;
	@Autowired
	private AuthorServ authorServ;
	

	@RequestMapping(value = "admin_area", method = RequestMethod.GET)
	public String getList(Model model) {
		model.addAttribute("listCategory", categoryServ.findAll());
		model.addAttribute("listBook", bookServ.findAll());
		model.addAttribute("listCell", cellServ.findAll());
		model.addAttribute("listClient", clientServ.findAll());
		model.addAttribute("listJournal", journalServ.findAll());
		
		
		return "adminArea";
	}
	
	@RequestMapping(value = "admin_area", method = RequestMethod.POST)
	public String delete(Model model, @ModelAttribute("action") String parameter) {
		String[] comand = parameter.split("_");
		if (comand[0].equals("del")) {
			switch (comand[1]) {
			case "category":
				categoryServ.delete(new Category(Long.parseLong(comand[2])));
				break;
			case "client":
				clientServ.delete(new Client(Long.parseLong(comand[2])));
				break;
			case "book":
				bookServ.delete(new Book(Long.parseLong(comand[2])));
				break;
			case "cell":
				cellServ.delete(new Cell(Long.parseLong(comand[2])));
				break;
			case "author":
				model.addAttribute("listAuthor", authorServ.findAll());
				return "author";
			}
			
			return getList(model);
		} else throw new RuntimeException("Comand not found!");
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getPage(Model model) {
		return "redirect:/login";
	}
}
