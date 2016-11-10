package com.nixsolutions.spring.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nixsolutions.spring.model.db.dao.ClientDAO;
import com.nixsolutions.spring.model.db.entity.Author;
import com.nixsolutions.spring.model.db.entity.Book;
import com.nixsolutions.spring.model.db.entity.Category;
import com.nixsolutions.spring.model.db.entity.Cell;
import com.nixsolutions.spring.model.db.entity.Client;
import com.nixsolutions.spring.model.db.entity.Journal;
import com.nixsolutions.spring.model.service.AuthorServ;
import com.nixsolutions.spring.model.service.BookServ;
import com.nixsolutions.spring.model.service.CategoryServ;
import com.nixsolutions.spring.model.service.CellServ;
import com.nixsolutions.spring.model.service.ClientServ;
import com.nixsolutions.spring.model.service.JournalServ;

@Controller
public class DataChangesAdminPost {
	@Autowired
	CategoryServ categoryServ;
	@Autowired
	AuthorServ authorServ;
	@Autowired
	CellServ cellServ;
	@Autowired
	BookServ bookServ;
	@Autowired
	ClientServ clientServ;
	@Autowired
	JournalServ journalServ;

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	
	@RequestMapping(value = "data_variation_category", method = RequestMethod.POST)
	public String dataChanges(@ModelAttribute("category") Category category) {
		if (category.getCategoryID() == null)
			categoryServ.save(category);
		else categoryServ.update(category);
		
		return "redirect:/admin_area";
	}
	
	@RequestMapping(value = "data_variation_author", method = RequestMethod.POST)
	public String dataChanges(@ModelAttribute("author") Author author) {
		if (author.getAuthorID() == null)
			authorServ.save(author);
		else authorServ.update(author);
		
		return "redirect:/admin_area";
	}
	
	@RequestMapping(value = "data_variation_cell", method = RequestMethod.POST)
	public String dataChanges(@ModelAttribute("cell") Cell cell) {
		if (cell.getCellID() == null)
			cellServ.save(cell);
		else cellServ.update(cell);
		
		return "redirect:/admin_area";
	}
	
	@RequestMapping(value = "data_variation_book", method = RequestMethod.POST)
	public String dataChanges(@ModelAttribute("book") Book book, HttpServletRequest request) {
		if (book.getBookID() == null)
			bookServ.save(book, request.getParameterValues("authors1"), request.getParameter("cellID"));
		else bookServ.update(book, request.getParameterValues("authors1"), request.getParameter("cellID"));
		
		return "redirect:/admin_area";
	}
	
	@RequestMapping(value = "data_variation_client", method = RequestMethod.POST)
	public String dataChanges(@ModelAttribute("client") Client client) {
		if (client.getClientID() == null)
			clientServ.save(client);
		else clientServ.update(client);
		
		return "redirect:/admin_area";
	}
	
	@RequestMapping(value = "data_variation_journal", method = RequestMethod.POST)
	public String dataChanges(@ModelAttribute("journal") Journal journal) {
		journalServ.update(journal);
		
		return "redirect:/admin_area";
	}
	
	@RequestMapping(value = "issue_book", method = RequestMethod.POST)
	public String issueBook(@ModelAttribute("journal") Journal journal) {
		journalServ.save(journal);
		
		return "redirect:/admin_area";
	}
	
	@RequestMapping(value = "take_book", method = RequestMethod.POST)
	public String issueBook(HttpServletRequest request, HttpServletResponse response) {
		try {
			Long recordID = Long.parseLong(request.getParameter("action").split("_")[1]);
			Journal journal = journalServ.findByID(new Journal(recordID));
			
			journal.setDateFactReturn(Journal.formater.parse(request.getParameter("dateFactReturn")));
			journalServ.take(journal);
			
			Cell cell = cellServ.findByID(new Cell(Long.parseLong(request.getParameter("cellID"))));
			cell.setBook(journal.getBook());
			cellServ.update(cell);
			
			return "redirect:/admin_area";
		} catch (ParseException e) {
			return "redirect:/admin_area";
		}
		
	}
}
