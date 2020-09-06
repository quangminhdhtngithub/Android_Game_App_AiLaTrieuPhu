package com.example.android_game_app_ailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.Random;

public class DialogKhanGiaTraLoi extends Dialog {
    public DialogKhanGiaTraLoi(Context context, int vtD, boolean true5050, String conLai) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog_khan_gia_tra_loi);
        TextView txvChonA,txvChonB,txvChonC,txvChonD;
        txvChonA = findViewById(R.id.txvChonA);
        txvChonB = findViewById(R.id.txvChonB);
        txvChonC = findViewById(R.id.txvChonC);
        txvChonD = findViewById(R.id.txvChonD);

        int arrdrom[] = new int[]{0,0};
        int can = 74;
        for(int i=0;i<arrdrom.length;i++){
            arrdrom[i]=arrdrom[i]+can;// 25 50 100 125
            if(i==vtD-1){
                arrdrom[i]=arrdrom[i]+25; // 25 50 100
                can = can+25;//100
            }
            can = can+25;//can 125
        }

        int tong = 125;
        int arrPhanTramTl[] = new int[]{0,0}; // a  b  c d
        int soKhanGia = 200;
        Random r = new Random();
        for(int i=0;i<soKhanGia;i++){
            int chon = r.nextInt(tong);// 0 25 75 100 125
            if(chon>=0 && chon<arrdrom[0]){
                arrPhanTramTl[0]++;
            }else if(chon>= arrdrom[0] && chon<arrdrom[1]){
                arrPhanTramTl[1]++;
            }
        }

        int t = r.nextInt(arrPhanTramTl.length);
        arrPhanTramTl[t] = arrPhanTramTl[t]+2;
        if(conLai.equals("01") || conLai.equals("10")){
            txvChonA.setVisibility(View.VISIBLE);
            txvChonB.setVisibility(View.VISIBLE);
            txvChonA.setText("C : "+(int)(arrPhanTramTl[0]*100/soKhanGia)+" %");
            txvChonB.setText("D : "+(int)(arrPhanTramTl[1]*100/soKhanGia)+" %");
        }
        if(conLai.equals("02")|| conLai.equals("20")){
            txvChonA.setVisibility(View.VISIBLE);
            txvChonC.setVisibility(View.VISIBLE);
            txvChonA.setText("B : "+(int)(arrPhanTramTl[0]*100/soKhanGia)+" %");
            txvChonC.setText("D : "+(int)(arrPhanTramTl[1]*100/soKhanGia)+" %");
        }
        if(conLai.equals("03")|| conLai.equals("30")){
            txvChonA.setVisibility(View.VISIBLE);
            txvChonD.setVisibility(View.VISIBLE);
            txvChonA.setText("B : "+(int)(arrPhanTramTl[0]*100/soKhanGia)+" %");
            txvChonD.setText("C : "+(int)(arrPhanTramTl[1]*100/soKhanGia)+" %");
        }
        if(conLai.equals("12")|| conLai.equals("21")){
            txvChonB.setVisibility(View.VISIBLE);
            txvChonC.setVisibility(View.VISIBLE);
            txvChonB.setText("A : "+(int)(arrPhanTramTl[0]*100/soKhanGia)+" %");
            txvChonC.setText("D : "+(int)(arrPhanTramTl[1]*100/soKhanGia)+" %");
        }
        if(conLai.equals("13")|| conLai.equals("31")){
            txvChonB.setVisibility(View.VISIBLE);
            txvChonD.setVisibility(View.VISIBLE);
            txvChonB.setText("A : "+(int)(arrPhanTramTl[0]*100/soKhanGia)+" %");
            txvChonD.setText("C : "+(int)(arrPhanTramTl[1]*100/soKhanGia)+" %");
        }
        if(conLai.equals("23")|| conLai.equals("32")){
            txvChonC.setVisibility(View.VISIBLE);
            txvChonD.setVisibility(View.VISIBLE);
            txvChonC.setText("A : "+(int)(arrPhanTramTl[0]*100/soKhanGia)+" %");
            txvChonD.setText("B : "+(int)(arrPhanTramTl[1]*100/soKhanGia)+" %");
        }
    }
    public DialogKhanGiaTraLoi(Context context, int vtD) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog_khan_gia_tra_loi);
        TextView txvChonA,txvChonB,txvChonC,txvChonD;
        txvChonA = findViewById(R.id.txvChonA);
        txvChonB = findViewById(R.id.txvChonB);
        txvChonC = findViewById(R.id.txvChonC);
        txvChonD = findViewById(R.id.txvChonD);

        int arrdrom[] = new int[]{0,0,0,0};
        int can = 25;
        for(int i=0;i<arrdrom.length;i++){
            arrdrom[i]=arrdrom[i]+can;// 25 50 100 125
            if(i==vtD-1){
                arrdrom[i]=arrdrom[i]+25; // 25 50 100
                can = can+25;//100
            }
            can = can+25;//can 125
        }

        int tong = 125;
        int arrPhanTramTl[] = new int[]{0,0,0,0}; // a  b  c d
        int soKhanGia = 200;
        Random r = new Random();
        for(int i=0;i<soKhanGia;i++){
            int chon = r.nextInt(tong);// 0 25 75 100 125
            if(chon>=0 && chon<arrdrom[0]){
                arrPhanTramTl[0]++;
            }else if(chon>= arrdrom[0] && chon<arrdrom[1]){
                arrPhanTramTl[1]++;
            }else if(chon>= arrdrom[1] && chon<arrdrom[2]){
                arrPhanTramTl[2]++;
            }else {
                arrPhanTramTl[3]++;
            }
        }
        int t = r.nextInt(arrPhanTramTl.length);
        arrPhanTramTl[t] = arrPhanTramTl[t]+2;
        txvChonA.setVisibility(View.VISIBLE);
        txvChonB.setVisibility(View.VISIBLE);
        txvChonC.setVisibility(View.VISIBLE);
        txvChonD.setVisibility(View.VISIBLE);
        txvChonA.setText("A : "+(int)(arrPhanTramTl[0]*100/soKhanGia)+" %");
        txvChonB.setText("B : "+(int)(arrPhanTramTl[1]*100/soKhanGia)+" %");
        txvChonC.setText("C : "+(int)(arrPhanTramTl[2]*100/soKhanGia)+" %");
        txvChonD.setText("D : "+(int)(arrPhanTramTl[3]*100/soKhanGia)+" %");
    }
}