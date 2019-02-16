package ru.andersen.gagarin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.andersen.gagarin.Query.*;

public class DataBaseActions {
    static void backupDB(Connection c) throws SQLException {
        execute(c, BackupDB);
    }

    static void dropDB(Connection c) throws SQLException {
        execute(c, DropDB);
    }

    static void createDB(Connection c) throws SQLException {
        execute(c, CreateDB);
    }

    static void createTables(Connection c) throws SQLException {
        useDB(c);
        createLocationTable(c);
        createStuffTable(c);
        createUserTypeTable(c);
        createSkyCharTable(c);
        createWindCharTable(c);
        createUserTable(c);
        createWeatherCharTable(c);
        createDateTable(c);
    }

    private static void useDB(Connection c) throws SQLException {
        execute(c, UseDB);
    }

    private static void createLocationTable(Connection c) throws SQLException {
        execute(c, LocationTable);
    }

    private static void createStuffTable(Connection c) throws SQLException {
        execute(c, StuffTable);
    }

    private static void createUserTypeTable(Connection c) throws SQLException {
        execute(c, UserTypeTable);
    }

    private static void createSkyCharTable(Connection c) throws SQLException {
        execute(c, SkyCharTable);
    }

    private static void createWindCharTable(Connection c) throws SQLException {
        execute(c, WindCharTable);
    }

    private static void createUserTable(Connection c) throws SQLException {
        execute(c, UserTable);
    }

    private static void createWeatherCharTable(Connection c) throws SQLException {
        execute(c, WeatherCharTable);
    }

    private static void createDateTable(Connection c) throws SQLException {
        execute(c, DateTable);
    }


    static void createFK(Connection c) throws SQLException {
        execute(c, FK_TypeUser);
        execute(c, FK_LocationUser);
        execute(c, FK_WindWeather);
        execute(c, FK_SkyWeather);
        execute(c, FK_LocationDate);
        execute(c, FK_WeatherDate);
        execute(c, FK_StuffDate);
    }

    static void insertInfo(Connection c) throws SQLException {
        execute(c, InsertIntoWind);
        execute(c, InsertIntoWind2);
        execute(c, InsertIntoWeather);

    }

    static ResultSet getResultAction(Connection c) throws SQLException {
        return c.prepareStatement("SELECT * FROM weatherdb.windchar;").executeQuery();
    }

    private static void execute(Connection c, Query q) throws SQLException {
        c.prepareStatement(q.getQuery()).execute();
    }


}
