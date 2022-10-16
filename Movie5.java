package net.sqlitetutorial;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Movie5 {

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

    
    public void selectAll(){
        String sql = "SELECT movie_name, actor_name, actress_name,director_name,release_year FROM movies";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            while (rs.next()) {
                System.out.println(rs.getString("movie_name") +  "\t" + 
                                   rs.getString("actor_name") + "\t" +
                                   rs.getString("actress_name") + "\t" +
                                   rs.getString("director_name") + "\t" +
                                   rs.getInt("release_year"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
   
    
    public static void main(String[] args) {
        Movie5 app = new Movie5();
        app.selectAll();
    }

}