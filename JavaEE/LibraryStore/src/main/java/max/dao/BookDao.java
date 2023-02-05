package max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import max.model.Book;

public class BookDao {

	private Connection con;
	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
	public BookDao(Connection con) {
		this.con = con;
	}
	
	public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try {

            query = "select * from books";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
            	Book row = new Book();
                row.setId(rs.getLong("id"));
                row.setAuthor(rs.getString("author"));
                row.setTitle(rs.getString("title"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getBigDecimal("price"));
                row.setImage(rs.getString("image"));

                books.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return books;
    }
}
