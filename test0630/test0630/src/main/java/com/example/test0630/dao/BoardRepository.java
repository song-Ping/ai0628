package com.example.test0630.dao;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class BoardRepository {
    public BoardRepository(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                    "root",
                    "1234");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM people");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " + resultSet.getString("age"));
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
