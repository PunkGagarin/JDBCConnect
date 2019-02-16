package ru.andersen.gagarin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.andersen.gagarin.DataBaseActions.*;


public class UpdateDbService {
    private static String url = "jdbc:mysql://localhost:3306/weatherdb?autoReconnect=true&useSSL=false";
    private static String user = "root";
    private static String password = "12345";


    public static void rebuildDB() {

        //Где использовать try catch block? На том уровне, где достаточно информации.
        // В нашем случае это текущий класс или метод main?
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection(url, user, password)) {
            //наши стейтменты
            //backupDB(c);
            dropDB(c);
            createDB(c);
            createTables(c);
            createFK(c);
            insertInfo(c);

            //какое-то полезное действие, откуда мы получим наш результат, ResultSet.
            ResultSet rs = getResultAction(c);

            //Выводим данные на экран
            if(rs.next())
            System.out.println("Сегодня "+rs.getString("WindName"));

            //Уведомляем о пересоздании БД
            System.out.println("БД была пересоздана");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

