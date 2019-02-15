package ru.andersen.gagarin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class updateDbService {

    public static void main(String[] args) {

        String url = "";
        String user = "";
        String password = "";


        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection  c = DriverManager.getConnection(url, user, password)) {

           //наши стейтменты
            c.prepareStatement(Query.BACKUPDB.getQuery()).execute();
            c.prepareStatement(Query.DROPDB.getQuery()).execute();
            //остальные стейтменты

            //какое-то полезное действие, откуда мы получим наш результат, ResultSet.
            ResultSet rs = c.prepareStatement("asdf").executeQuery();
            System.out.println(rs.getString("Нужная нам колонка"));
            System.out.println("БД была пересоздана");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
