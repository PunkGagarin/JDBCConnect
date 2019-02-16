package ru.andersen.gagarin;

//запросы к бд
public enum Query {
    BackupDB("BACKUP DATABASE weatherdb TO DISK = 'C:\\WeatherDB\\testDB.bak';"),

    DropDB("DROP DATABASE IF EXIST weatherdb;"),

    CreateDB("CREATE DATABASE weatherdb;"),

    LocationTable("CREATE TABLE location (\n" +
            "CityID int(5) AUTO_INCREMENT NOT NULL,\n" +
            "City varchar(40),\n" +
            "PRIMARY KEY ( CityID)\n" +
            ");"),

    StuffTable("CREATE TABLE stuff (\n" +
            "StuffID int(5) AUTO_INCREMENT NOT NULL,\n" +
            "StuffName varchar(255),\n" +
            "Link varchar(255) ,\n" +
            "PRIMARY KEY(StuffID)\n" +
            ");"),

    UserTypeTable("CREATE TABLE usertype (\n" +
            "UserTypeID int(5) AUTO_INCREMENT NOT NULL,\n" +
            "UserTypeName varchar(30),\n" +
            "PRIMARY KEY(UserTypeID)\n" +
            ");"),

    SkyCharTable("CREATE TABLE skychar(\n" +
            "SkyID int(5) AUTO_INCREMENT NOT NULL,\n" +
            "SkyName varchar(130),\n" +
            "Precipitation varchar(50),\n" +
            "PrecAmount int(10),\n" +
            "PRIMARY KEY(SkyID)\n" +
            ");"),

    WindCharTable("CREATE TABLE windchar(\n" +
            "WindID int(5) AUTO_INCREMENT NOT NULL,\n" +
            "WindName varchar(40),\n" +
            "Speed int(8),\n" +
            "Direction varchar(40),\n" +
            "Points int(2),\n" +
            "PRIMARY KEY(WindID)\n" +
            ");"),

    UserTable("CREATE TABLE user(\n" +
            "UserID int(10) AUTO_INCREMENT NOT NULL,\n" +
            "Type int(5),\n" +
            "UserName varchar(80),\n" +
            "Login varchar(45) UNIQUE NOT NULL,\n" +
            "Password varchar(40) NOT NULL,\n" +
            "Location int(5),\n" +
            "PRIMARY KEY (UserID)\n" +
            ");"),

    WeatherCharTable("CREATE TABLE weatherchar(\n" +
            "WeatherID int(5) AUTO_INCREMENT NOT NULL,\n" +
            "Temperature int(5),\n" +
            "Pressure int(5),\n" +
            "Wind int(5),\n" +
            "Sky int(5),\n" +
            "PRIMARY KEY (WeatherID)\n" +
            ");"),

    DateTable("CREATE TABLE date(\n" +
            "DateID int(5) AUTO_INCREMENT NOT NULL,\n" +
            "Date date,\n" +
            "Location int(5),\n" +
            "Weather int(5),\n" +
            "Stuff int(5),\n" +
            "PRIMARY KEY (DateID)\n" +
            ");"),

    FK_TypeUser("ALTER TABLE user \n" +
            "ADD CONSTRAINT FK_TypeUser\n" +
            "FOREIGN KEY (Type) REFERENCES \tusertype(UserTypeID);"),

    FK_LocationUser("ALTER TABLE user \n" +
            "ADD CONSTRAINT FK_LocationUser\n" +
            "FOREIGN KEY (Location) REFERENCES \tlocation(CityID);"),

    FK_WindWeather("ALTER TABLE weatherchar\n" +
            "ADD CONSTRAINT FK_WindWeather\n" +
            "FOREIGN KEY (Wind) REFERENCES windchar(WindID);"),

    FK_SkyWeather("ALTER TABLE weatherchar\n" +
            "ADD CONSTRAINT FK_SkyWeather\n" +
            "FOREIGN KEY (Sky) REFERENCES skychar(SkyID);"),

    FK_LocationDate("ALTER TABLE date\n" +
            "ADD CONSTRAINT FK_LocationDate\n" +
            "FOREIGN KEY (Location) REFERENCES location(CityID);"),

    FK_WeatherDate("ALTER TABLE date\n" +
            "ADD CONSTRAINT FK_WeatherDate\n" +
            "FOREIGN KEY (Weather) REFERENCES weatherchar(WeatherID);"),

    FK_StuffDate("ALTER TABLE date\n" +
            "ADD CONSTRAINT FK_StuffDate\n" +
            "FOREIGN KEY (Stuff) REFERENCES stuff(StuffID);");


    private String query;

    Query(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
