package ru.andersen.gagarin;

//запросы к бд
public enum Query {
    BACKUPDB ("BACKUP DATABASE weatherdb;"),
    DROPDB ("DROP DATABASE weatherdb;"),
    CREATEDB ("CREATE DATABASE weatherdb;")
    ;


    private String query;

    Query(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
