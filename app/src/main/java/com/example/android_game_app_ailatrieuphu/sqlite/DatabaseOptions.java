package com.example.android_game_app_ailatrieuphu.sqlite;

public class DatabaseOptions {
    public static final String DATA_NAME = "data.sqlite";

    public static final String USERS_TABLE = "users";
    public static final String ID_USER = "id";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String TOTAL_POINT = "totalpoint";

    public static final String CREATE_USERS_TABLE_ =
            "CREATE TABLE  " + USERS_TABLE + "(" +
                    ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    EMAIL + " TEXT NOT NULL, " +
                    PASSWORD + " TEXT NOT NULL, " +
                    TOTAL_POINT + " TEXT)";

    public static final String HISTORY_TABLE = "history";
    //    public static final String ID_HISTORY = "id";
    public static final String EMAIL_HISTORY = "email";
    public static final String NOTE = "note ";
    public static final String CHANGE_POINT = "changpoint";

    public static final String CREATE_HISTORY_TABLE =
            "CREATE TABLE  " + HISTORY_TABLE + "(" +
//                    ID_HISTORY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    EMAIL_HISTORY + " TEXT NOT NULL, " +
                    CHANGE_POINT + " TEXT NOT NULL, " +
                    NOTE + " TEXT NOT NULL)";

    public static final String CAUHOI_TABLE = "Cauhoi";
    public static final String ID_CAUHOI = "id ";
    public static final String CAP_DO = "capdo ";
    public static final String NOI_DUNG = "noidung ";
    public static final String DAP_AN = "dapan ";
    public static final String DAP_AN_SAI = "dapansai ";

    public static final String CREATE_CAUHOI_TABLE_ =
            "CREATE TABLE " + CAUHOI_TABLE + "(" +
                    ID_CAUHOI + "integer primary key" + " autoincrement," +
                    CAP_DO + "integer, " +
                    NOI_DUNG + "TEXT, " +
                    DAP_AN + "TEXT, " +
                    DAP_AN_SAI + "TEXT)";


}
