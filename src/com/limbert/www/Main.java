package com.limbert.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        creatTable();
        post();
    }

    public static void post() throws Exception{
        final String var1 = "john";
        final String var2 = "Miller";

        try{
            Connection conn = getConnection();
            PreparedStatement posted = conn.prepareStatement("INSERT INTO tabelname(first,last) VALUES ('"+var1+"', '"+var2+"')");

            posted.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }finally {
            System.out.println("Insert Completed!");
        }
    }
    public static void creatTable() throws Exception{
        try{
            Connection conn = getConnection();
            PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS tabelname(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))");

            create.executeUpdate();

        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("Function completed");
        }
    }

    public static Connection getConnection() throws Exception{
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/testdb";
            String username = "root";
            String password = "root";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return conn;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}

