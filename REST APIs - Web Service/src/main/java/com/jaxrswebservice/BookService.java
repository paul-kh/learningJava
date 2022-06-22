package com.jaxrswebservice;

import com.applicationdao.BookDAO;
import com.applicationentities.Book;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/bookservice")
public class BookService {

    @GET
    @Path("/getbooks")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks() {

        List<Book> listOfBooks = BookDAO.getAllBooks();

        //jersey-media-json-jackson library will auto convert response object
        // to be JSON to be sent over HTTP to client.
        // jersey-media-json-jackson needs to be added as dependency in the "pom.xml" file
        return Response.status(Response.Status.OK).entity(listOfBooks).build();

    }

}