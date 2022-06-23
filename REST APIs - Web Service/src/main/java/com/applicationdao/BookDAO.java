package com.applicationdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.applicationentities.Book;

public class BookDAO {

    private static Connection myDB = null;
    private static final String url = "jdbc:mysql://localhost:3306/BookService";
    private static final String username = "root";
    private static final String password = "root";

    private BookDAO(){}

    public static Connection getConnection() {

        try {
            if(myDB == null) {

                Class.forName("com.mysql.cj.jdbc.Driver");
                myDB = DriverManager.getConnection(url, username, password);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return myDB;
    }


    public static List<Book> getAllBooks() {

        List<Book> list = new ArrayList<Book>();

        try {

            Connection myDB = getConnection();
            PreparedStatement ps = myDB.prepareStatement("select * from books");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Book book = new Book();

                book.setId(rs.getString("book_id"));
                book.setBookTitle(rs.getString("book_title"));
                book.setAuthorName(rs.getString("book_author"));
                book.setBookPrice(rs.getFloat("book_price"));

                list.add(book);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static Book getBookById(String book_id) {

        try {

            Connection myDB = getConnection();
            PreparedStatement ps = myDB.prepareStatement("select * from books where book_id=?");
            ps.setString(1, book_id);
            ResultSet rs = ps.executeQuery();


            if(rs.next()) {

                Book book = new Book();

                book.setId(rs.getString("book_id"));
                book.setBookTitle(rs.getString("book_title"));
                book.setAuthorName(rs.getString("book_author"));
                book.setBookPrice(rs.getFloat("book_price"));

                return book;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static String addBook(Book book) {

        int status = 0;
        String responseMessage = "";

        try {

            Connection myDB = getConnection();
            PreparedStatement ps = myDB
                    .prepareStatement("insert into books(book_id, book_title, book_author, book_price) values(?,?,?,?)");
            ps.setString(1, book.getId());
            ps.setString(2, book.getBookTitle());
            ps.setString(3, book.getAuthorName());
            ps.setFloat(4, book.getBookPrice());

            status = ps.executeUpdate();

            String successMsg = "Success : " + book.getId();
            String errorMsg = "Error : " + book.getId();

            responseMessage = (status == 1) ? successMsg : errorMsg;

        } catch (Exception e) {
            System.out.println(e);
            responseMessage = "Error: " + e.getMessage();
        }
        System.out.println("Returning response message: " + responseMessage);
        return responseMessage;
    }

    public static String updateBook(Book book) {

        int status = 0;
        String responseMessage = "";

        try {
            Connection myDB = getConnection();
            PreparedStatement ps = myDB
                    .prepareStatement("update books set book_title=?,book_author=?,book_price=? where book_id=?");
            ps.setString(1, book.getBookTitle());
            ps.setString(2, book.getAuthorName());
            ps.setFloat(3, book.getBookPrice());
            ps.setString(4, book.getId());

            status = ps.executeUpdate();

            String successMsg = "Success : " + book.getId();
            String errorMsg = "Error : " + book.getId();

            responseMessage = (status == 1) ? successMsg : errorMsg;

        } catch (Exception e) {
            System.out.println(e);
            responseMessage = "Error: " + e.getMessage();
        }
        System.out.println("Returning response message: " + responseMessage);
        return responseMessage;
    }
}
