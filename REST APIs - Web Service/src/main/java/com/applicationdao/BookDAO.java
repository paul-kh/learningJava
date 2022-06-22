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
}
