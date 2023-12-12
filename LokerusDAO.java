/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lokerus2;

/**
 *
 * @author Azhar Nurulhaifa
 */
import static java.lang.String.format;
import java.sql.*;

public class LokerusDAO {
    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private Statement stmt;
    
    public LokerusDAO() {
        url = "jdbc:mysql://localhost/ lokerus";
        uname = "root";
        pass = "Azh@#195#*";
        setConnectionAndStatement();
    }
    
    private void setConnectionAndStatement() {
        try {
            con = DriverManager.getConnection(url,uname,pass);
            stmt = con.createStatement();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUrl() {
        return url;
    }

    public String getUname() {
        return uname;
    }

    public String getPass() {
        return pass;
    }
    
    public void save (User user) {
        try {
            String query = "INSERT INTO user VALUES ('%s', '%s', '%s')";
            query = format(
                        query,
                        user.getUsername(),
                        user.getPassword(),
                        user.getRole());
            stmt.executeUpdate(query);
            System.out.println("Berhasil menambahkan data!");
        } catch (SQLException ex) {
            System.out.println("Error inserting data:" + ex.getMessage());
            System.exit(1);
        }
    }
}