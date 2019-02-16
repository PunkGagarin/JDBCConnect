package ru.andersen.gagarin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseActions {
    static void backupDB(Connection c) throws SQLException {
        execute(c,Query.BackupDB);
    }

    static void dropDB(Connection c) throws SQLException {
        execute(c,Query.DropDB);
    }

    static void createDB(Connection c) throws SQLException{
        execute(c,Query.CreateDB);
    }

    static void createTables(Connection c) throws SQLException{
        createLocationTable(c);
        createStuffTable(c);
        createUserTypeTable(c);
        createSkyCharTable(c);
        createWindCharTable(c);
        createUserTable(c);
        createWeatherCharTable(c);
        createDateTable(c);
    }

    private static void createLocationTable(Connection c) throws SQLException{
        execute(c,Query.LocationTable);
    }

    private static void createStuffTable(Connection c) throws SQLException{
        execute(c,Query.StuffTable);
    }

    private static void createUserTypeTable(Connection c) throws SQLException{
        execute(c,Query.UserTypeTable);
    }

    private static void createSkyCharTable(Connection c) throws SQLException{
        execute(c,Query.SkyCharTable);
    }

    private static void createWindCharTable(Connection c) throws SQLException{
        execute(c,Query.WindCharTable);
    }

    private static void createUserTable(Connection c) throws SQLException{
        execute(c,Query.UserTable);
    }

    private static void createWeatherCharTable(Connection c) throws SQLException{
        execute(c,Query.WeatherCharTable);
    }

    private static void createDateTable(Connection c) throws SQLException{
        execute(c,Query.DateTable);
    }


    static void createFK(Connection c) throws SQLException{
        execute(c,Query.FK_TypeUser);
        execute(c,Query.FK_LocationUser);
        execute(c,Query.FK_WindWeather);
        execute(c,Query.FK_SkyWeather);
        execute(c,Query.FK_LocationDate);
        execute(c,Query.FK_WeatherDate);
        execute(c,Query.FK_StuffDate);
    }

    static ResultSet getResultAction(Connection c) throws SQLException{
        return c.prepareStatement("asdf").executeQuery();
    }

    private static void execute(Connection c, Query q) throws SQLException{
        c.prepareStatement(q.getQuery()).execute();
    }


}
