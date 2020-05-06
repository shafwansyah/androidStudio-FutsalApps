package com.example.futsalapps;

public class Constant {

    public static final String DB_NAME = "BOOK_FUTSAL_DB";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME ="BOOK_FUTSAL_TABLE";
    public static final String C_ID ="ID";
    public static final String C_NAME ="NAME";
    public static final String C_DATE ="DATE";
    public static final String C_TIME ="TIME";
    public static final String C_PERIOD ="PERIOD";
    public static final String C_ADD_TIMESTAMP ="ADD_TIMESTAMP";

    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + C_NAME + " TEXT,"
            + C_DATE + " TEXT,"
            + C_TIME + " TEXT,"
            + C_PERIOD + " TEXT,"
            + C_ADD_TIMESTAMP + " TEXT"
            + " );";


}
