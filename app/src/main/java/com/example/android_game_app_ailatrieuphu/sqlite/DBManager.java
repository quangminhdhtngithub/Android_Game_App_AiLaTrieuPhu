package com.example.android_game_app_ailatrieuphu.sqlite;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.example.android_game_app_ailatrieuphu.object.User;
import com.example.android_game_app_ailatrieuphu.object.CauHoi;

import java.util.ArrayList;
import java.util.HashMap;

public class DBManager {
    private Context context;
    private SQLiteDatabase database;
    private com.example.android_game_app_ailatrieuphu.sqlite.MyDatabasehelper databasehelper;

    public DBManager(Context c){
        this.context = c;
    }

    public DBManager open() throws SQLException {
        this.databasehelper = new com.example.android_game_app_ailatrieuphu.sqlite.MyDatabasehelper(this.context);
        this.database = this.databasehelper.getWritableDatabase();
        this.database = this.databasehelper.getReadableDatabase();
        return this;
    }

    public void close(){
        this.databasehelper.close();
    }

    public ArrayList<ArrayList<CauHoi>> getcauhoi(){
        ArrayList<ArrayList<CauHoi>> arrCH = new ArrayList<>();
        HashMap<Integer,ArrayList<CauHoi>> arrch = new HashMap<>();
        Cursor cursor = this.database.query("Cauhoi",
                new String[]{"capdo", "noidung", "dapan", "dapansai"},
                null,null,null,null,null);
        while (cursor.moveToNext()){
            int capdo = cursor.getInt(cursor.getColumnIndex("capdo"));
            ArrayList<CauHoi> arrCapDo = arrch.get(capdo);
            if(arrCapDo == null){
                arrCapDo = new ArrayList<>();
            }
            arrCapDo.add(taoCauHoi(
                    cursor.getString(cursor.getColumnIndex("noidung")),
                    cursor.getString(cursor.getColumnIndex("dapan")),
                    cursor.getString(cursor.getColumnIndex("dapansai"))
            ));
            arrch.put(capdo,arrCapDo);
        }
        for (int i=1; i<16; i++){
            arrCH.add(arrch.get(i));
        }
        return arrCH;
    }

    private CauHoi taoCauHoi(String s1, String s2, String s3) {
        CauHoi ch = new CauHoi();
        ch.setNoiDung(s1);
        ch.setDapAnDung(s2);
        ch.setArrDapAnSai(s3);
        return ch;
    }

}
