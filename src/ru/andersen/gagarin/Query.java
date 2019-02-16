package ru.andersen.gagarin;

//запросы к бд
public enum Query {
    BackupDB("BACKUP DATABASE weatherdb TO DISK = 'C:\\WeatherDB\\testDB.bak';"),

    DropDB("DROP DATABASE IF EXIST weatherdb;"),

    CreateDB("CREATE DATABASE weatherdb;"),

    LocationTable("CREATE TABLE location (" +
            "CityID int(5) AUTO_INCREMENT NOT NULL," +
            "City varchar(40)," +
            "PRIMARY KEY ( CityID)" +
            ");"),

    StuffTable("CREATE TABLE stuff (" +
            "StuffID int(5) AUTO_INCREMENT NOT NULL," +
            "StuffName varchar(255)," +
            "Link varchar(255) ," +
            "PRIMARY KEY(StuffID)" +
            ");"),

    UserTypeTable("CREATE TABLE usertype (" +
            "UserTypeID int(5) AUTO_INCREMENT NOT NULL," +
            "UserTypeName varchar(30)," +
            "PRIMARY KEY(UserTypeID)" +
            ");"),

    SkyCharTable("CREATE TABLE skychar(" +
            "SkyID int(5) AUTO_INCREMENT NOT NULL," +
            "SkyName varchar(130)," +
            "Precipitation varchar(50)," +
            "PrecAmount int(10)," +
            "PRIMARY KEY(SkyID)" +
            ");"),

    WindCharTable("CREATE TABLE windchar(" +
            "WindID int(5) AUTO_INCREMENT NOT NULL," +
            "WindName varchar(40)," +
            "Speed int(8)," +
            "Direction varchar(40)," +
            "Points int(2)," +
            "PRIMARY KEY(WindID)" +
            ");"),

    UserTable("CREATE TABLE user(" +
            "UserID int(10) AUTO_INCREMENT NOT NULL," +
            "Type int(5)," +
            "UserName varchar(80)," +
            "Login varchar(45) UNIQUE NOT NULL," +
            "Password varchar(40) NOT NULL," +
            "Location int(5)," +
            "PRIMARY KEY (UserID)" +
            ");"),

    WeatherCharTable("CREATE TABLE weatherchar(" +
            "WeatherID int(5) AUTO_INCREMENT NOT NULL," +
            "Temperature int(5)," +
            "Pressure int(5)," +
            "Wind int(5)," +
            "Sky int(5)," +
            "PRIMARY KEY (WeatherID)" +
            ");"),

    DateTable("CREATE TABLE date(" +
            "DateID int(5) AUTO_INCREMENT NOT NULL," +
            "Date date," +
            "Location int(5)," +
            "Weather int(5)," +
            "Stuff int(5)," +
            "PRIMARY KEY (DateID)" +
            ");"),

    FK_TypeUser("ALTER TABLE user " +
            "ADD CONSTRAINT FK_TypeUser" +
            "FOREIGN KEY (Type) REFERENCES usertype(UserTypeID);"),

    FK_LocationUser("ALTER TABLE user " +
            "ADD CONSTRAINT FK_LocationUser" +
            "FOREIGN KEY (Location) REFERENCES location(CityID);"),

    FK_WindWeather("ALTER TABLE weatherchar" +
            "ADD CONSTRAINT FK_WindWeather" +
            "FOREIGN KEY (Wind) REFERENCES windchar(WindID);"),

    FK_SkyWeather("ALTER TABLE weatherchar" +
            "ADD CONSTRAINT FK_SkyWeather" +
            "FOREIGN KEY (Sky) REFERENCES skychar(SkyID);"),

    FK_LocationDate("ALTER TABLE date" +
            "ADD CONSTRAINT FK_LocationDate" +
            "FOREIGN KEY (Location) REFERENCES location(CityID);"),

    FK_WeatherDate("ALTER TABLE date" +
            "ADD CONSTRAINT FK_WeatherDate" +
            "FOREIGN KEY (Weather) REFERENCES weatherchar(WeatherID);"),

    FK_StuffDate("ALTER TABLE date" +
            "ADD CONSTRAINT FK_StuffDate" +
            "FOREIGN KEY (Stuff) REFERENCES stuff(StuffID);");


    private String query;

    Query(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
