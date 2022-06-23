package com.jaxrswebservice;

import com.applicationdao.BookDAO;
import com.applicationentities.Book;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes; //Allow data to be submitted to the API end point via POST method
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

        return Response.status(Response.Status.OK).entity(listOfBooks).build();

    }

    @GET
    @Path("/getbook/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBook(@PathParam("param") String bookId) {

        Book book = BookDAO.getBookById(bookId);

        if(book == null){

            String jsonResponse = "{\"message\": \"A book with the given ID does not exist\"," +
                    "\"bookId\": \"" + bookId + "\"}";

            return Response.status(Response.Status.NOT_FOUND)
                    .entity(jsonResponse)
                    .build();
        }

        return Response.status(Response.Status.OK).entity(book).build();

    }

    @POST
    @Path("/addbook")
    @Produces(MediaType.APPLICATION_JSON) //Make response to be in JSON format
    @Consumes(MediaType.APPLICATION_JSON) //Make the data submitted to the end point in JSON format
    public Response addBook(Book book) {

        String addMsg = BookDAO.addBook(book);

        if(addMsg.startsWith("Error")){

            String jsonResponse = "{\"error\": \"The book could not be added.\"," +
                    "\"message\": \"" + addMsg + "\"}";

            return Response.status(Response.Status.CONFLICT)
                    .entity(jsonResponse)
                    .build();
        }

        return Response.status(Response.Status.CREATED).entity(book).build();
    }
}
