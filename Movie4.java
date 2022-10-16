package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Movie4 {

    private Connection connect() {
        String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

   
    public void insert(String movie_name, String actor_name,String actress_name, String director_name , Integer release_year) {
        String sql = "INSERT INTO movies(movie_name,actor_name,actress_name,director_name ,release_year) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, movie_name);
            pstmt.setString(2, actor_name);
            pstmt.setString(3, actress_name);
            pstmt.setString(4, director_name);
            pstmt.setInteger(5, release_year);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public static void main(String[] args) {

        Movie4 app = new Movie4();
        app.insert("master","vijay","malavika","nelson",2014);
        app.insert("vikram","kamal","lakshmi","vasudevan" ,2018);
        app.insert("jai bhim","surya","ishwarya","karthik" ,2019);
    }

}