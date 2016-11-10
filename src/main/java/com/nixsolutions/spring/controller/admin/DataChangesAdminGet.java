package com.nixsolutions.spring.controller.admin;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nixsolutions.spring.model.db.entity.Author;
import com.nixsolutions.spring.model.db.entity.Book;
import com.nixsolutions.spring.model.db.entity.Category;
import com.nixsolutions.spring.model.db.entity.Client;
import com.nixsolutions.spring.model.db.entity.Journal;
import com.nixsolutions.spring.model.db.entity.Cell;
import com.nixsolutions.spring.model.service.AuthorServ;
import com.nixsolutions.spring.model.service.BookServ;
import com.nixsolutions.spring.model.service.CategoryServ;
import com.nixsolutions.spring.model.service.CellServ;
import com.nixsolutions.spring.model.service.ClientServ;
import com.nixsolutions.spring.model.service.JournalServ;

@Controller
public class DataChangesAdminGet {
	@Autowired
	private CategoryServ categoryServ;
	@Autowired
	private AuthorServ authorServ;
	@Autowired
	private BookServ bookServ;
	@Autowired
	private CellServ cellServ;
	@Autowired
	private ClientServ clientServ;
	@Autowired
	private JournalServ journalServ;
	
	
	@RequestMapping(value = "data_variation", method = RequestMethod.GET)
	public String getForm(Model model, @ModelAttribute("action") String parameter) {
		String[] comand = parameter.split("_");
		if (comand[0].equals("upd")) {
			switch (comand[1]) {
			case "category":
				Category category = categoryServ.findByID(new Category(Long.parseLong(comand[2])));
				model.addAttribute("category", category);
				return "data/category_data";
			case "client":
				Client client = clientServ.findByID(new Client(Long.parseLong(comand[2])));
				model.addAttribute("client", client);
				return "data/client_data";
			case "book":
				organizationFormForBook(model, comand[2]);
				return "data/book_data";
			case "cell":
				organizationFormForCell(model, comand[2]);
				return "data/cell_data";
			case "journal":
				organizationFormForJournal(model, comand[2]);
				return "data/journal_data";
			default:
				throw new RuntimeException("Comand not found!");
			}
		} else if (comand[0].equals("new")) {
			switch (comand[1]) {
			case "category":
				model.addAttribute("category", new Category());
				return "data/category_data";
			case "client":
				model.addAttribute("client", new Client());
				return "data/client_data";
			case "book":
				organizationFormForBook(model, null);
				return "data/book_data";
			case "cell":
				organizationFormForCell(model, null);
				return "data/cell_data";
			case "journal":
				Journal journalCh = journalServ.findByID(new Journal(Long.parseLong(comand[2])));
				model.addAttribute("journalChanges", journalCh);
				return "data/journal_detailed_data";
			default:
				throw new RuntimeException("Comand not found!");
			}
		} else {
			throw new RuntimeException("Comand not found!");
		}
	}	
	
	@RequestMapping(value = "issue_book", method = RequestMethod.GET)
	public String issueBook(Model model) {
		ArrayList<Book> listBook = bookServ.findAvailable();
		ArrayList<Client> listClient = clientServ.findAvailable();
		
		Calendar dateReturn = Calendar.getInstance();
		dateReturn.setLenient(true);		
		dateReturn.set(Calendar.DAY_OF_MONTH, (dateReturn.get(Calendar.DAY_OF_MONTH) + 10));
		
		Journal journal = new Journal();
		journal.setDateIssue(Calendar.getInstance().getTime());
		journal.setDateReturn(dateReturn.getTime());
		
		model.addAttribute("listBook", listBook);
		model.addAttribute("listClient", listClient);
		model.addAttribute("journal", journal);
		
		return "issue_book";
	}
	
	@RequestMapping(value = "take_book", method = RequestMethod.GET)
	public String takeBook(Model model) {
		ArrayList<Cell> emptyCells = cellServ.findByEmptyCell();
		ArrayList<Journal> listJournal = journalServ.findForTakeBook();
		
		model.addAttribute("listCell", emptyCells);
		model.addAttribute("listJournal", listJournal);
		
		return "take_book";
	}
	
	private void organizationFormForBook(Model model, String comand) {
		ArrayList<Author> listAuthor = authorServ.findAll();
		ArrayList<Cell> emptyCells = cellServ.findByEmptyCell();
		ArrayList<Category> listCategory = categoryServ.findAll();
		Book book;
		Cell bookCell;
		int size;
		
		if (comand == null) {
			book = new Book();
			bookCell = null;
			
			size = listAuthor.size() / 2;
		} else {
			book = bookServ.findByID(new Book(Long.parseLong(comand)));
			
			bookCell = cellServ.findByBook(new Cell(book));
			
			listCategory.remove(book.getCategory());
			
			
			for (Author author : book.getAuthors()) {
				listAuthor.remove(author);
			}
			
			size = listAuthor.size() / 2 + book.getAuthors().size();
		}
		
		
		model.addAttribute("book", book);
		model.addAttribute("bookCell", bookCell);
		model.addAttribute("emptyCells", emptyCells);
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("allAuthors", listAuthor);
		model.addAttribute("sizeSelect", (size < 15 ? 15 : size));
	}
	
	private void organizationFormForCell(Model model, String comand) {
		ArrayList<Book> listBookForCell = bookServ.findForCell();
		
		Cell cellCh = comand == null ? new Cell() : 
			cellServ.findByID(new Cell(Long.parseLong(comand)));
		
		model.addAttribute("cell", cellCh);
		model.addAttribute("listBookForCell", listBookForCell);
	}
	
	private void organizationFormForJournal(Model model, String comand) {
		Journal journalCh = journalServ.findByID(new Journal(Long.parseLong(comand)));
		
		ArrayList<Book> listBook = bookServ.findAvailable();
		ArrayList<Client> listClient = clientServ.findAvailable();
		
		if (listClient != null)
			listClient.remove(journalCh.getClient());
		if (listBook != null)
			listBook.remove(journalCh.getBook());
		
		model.addAttribute("journal", journalCh);
		model.addAttribute("listBook", listBook);
		model.addAttribute("listClient", listClient);
	}
}
