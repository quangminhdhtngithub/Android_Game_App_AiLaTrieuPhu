package com.example.ai_la_trieu_phu.object;

import android.content.Context;

import com.example.ai_la_trieu_phu.sqlite.DBManager;

import java.util.ArrayList;
import java.util.Random;

public class FakeData {
    public FakeData(Context ct) {
        layCauHoiSQLite(ct);
    }

    public void layCauHoiSQLite(Context ct){
        DBManager dbManager = new DBManager(ct);
        dbManager.open();
        arrCauHoi = new ArrayList<>(dbManager.getcauhoi());
        dbManager.close();
    }

    public CauHoi taoCauHoi(int capdo) {
        Random r = new Random();
        ArrayList<CauHoi> arr = arrCauHoi.get(capdo - 1);
        return arr.get(r.nextInt(arr.size()));
    }

    ArrayList<ArrayList<CauHoi>> arrCauHoi = new ArrayList<>();
}
