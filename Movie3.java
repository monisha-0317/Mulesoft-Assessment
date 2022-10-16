package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Movie3 {

    public static void createNewTable() {
        
        String url = "jdbc:sqlite:C://sqlite/db/tests.db";
        
        String sql = "CREATE TABLE IF NOT EXISTS movies (\n"
               
                + "	movie_name text NOT NULL,\n"
                + "	actor_name text NOT NULL,\n"
                + "	actress_name text NOT NULL,\n"
                + "	director_name text NOT NULL,\n"
                + "	release_year integer NOT NULL,\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createNewTable();
    }

}
