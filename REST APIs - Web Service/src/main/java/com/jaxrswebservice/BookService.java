package com.jaxrswebservice;

import com.applicationdao.BookDAO;
import com.applicationentities.Book;
import jakarta.ws.rs.*;
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

    @PUT
    @Path("/updatebook")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook(Book book) {

        String updateMsg = BookDAO.updateBook(book);

        if(updateMsg.startsWith("Error")){

            String jsonResponse = "{\"error\": \"The book could not be located.\"," +
                    "\"message\": \"" + updateMsg + "\"}";

            return Response.status(Response.Status.NOT_FOUND)
                    .entity(jsonResponse)
                    .build();
        }

        return Response.status(Response.Status.ACCEPTED).entity(book).build();
    }

    @DELETE
    @Path("/deletebook/{param}")
    // In case of success, response will be of TEXT_PLAIN, in case of error, response will be of JSON
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response deleteBook(@PathParam("param") String bookId) {

        String deleteMsg = BookDAO.removeBook(bookId);

        if(deleteMsg.startsWith("Error")){

            String jsonResponse = "{\"error\": \"The book could not be removed.\"," +
                    "\"message\": \"" + deleteMsg + "\"}";

            return Response.status(Response.Status.NOT_FOUND)
                    .entity(jsonResponse)
                    .build();
        }

        return Response.status(Response.Status.ACCEPTED)
                .entity("Book deleted. ID: " + bookId)
                .build();
    }
}
