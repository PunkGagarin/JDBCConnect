package ru.andersen.gagarin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.andersen.gagarin.DataBaseActions.*;


public class UpdateDbService {
    private static String url = "";
    private static String user = "";
    private static String password = "";

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
            backupDB(c);
            dropDB(c);
            createDB(c);
            createTables(c);
            createFK(c);

            //какое-то полезное действие, откуда мы получим наш результат, ResultSet.
            ResultSet rs = getResultAction(c);

            //Выводим данные на экран
            System.out.println(rs.getString("Нужная нам колонка"));

            //Уведомляем о пересоздании БД
            System.out.println("БД была пересоздана");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
