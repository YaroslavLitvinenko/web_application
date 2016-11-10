package com.nixsolutions.web.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nixsolutions.spring.model.db.entity.Author;
import com.nixsolutions.spring.model.service.AuthorServ;

@Component
@Path("/author")
public class CellService {
	@Autowired
	AuthorServ authorServ;
	
	@GET
    @Path ("/{id}")
	@Produces (MediaType.APPLICATION_JSON)
	public Author findBiID(@PathParam ("id") Long id) {
		Author author = new Author(id);
		author = authorServ.findByID(author);
		
		return author;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Author> findAll() {
		return authorServ.findAll();
	}
	
	@PUT
	@Path ("/{id}")
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Response update(Author author) {
		Author authorInBD = authorServ.findByID(author);
		if (authorInBD == null)
			return Response.status(400).build();
		authorServ.update(author);
		
		return Response.ok().build();
	}
	
	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Author save(Author author) {
		System.out.println(author.getAuthorID() + " " + author.getFirstName());
		authorServ.save(author);
		
		//return Response.status(Response.Status.OK).entity(author.getAuthorID()).build();
		return author;
	}
	
	@DELETE
	@Path ("/{id}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response delete(@PathParam ("id") Long id) {
		authorServ.delete(new Author(id));
		
		return Response.ok().build();
	}
	
}
