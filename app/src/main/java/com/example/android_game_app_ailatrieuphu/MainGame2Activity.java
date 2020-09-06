package com.example.android_game_app_ailatrieuphu;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_game_app_ailatrieuphu.adapter.TienThuongAdapter;
import com.example.android_game_app_ailatrieuphu.object.CauHoi;
import com.example.android_game_app_ailatrieuphu.object.FakeData;
import com.example.android_game_app_ailatrieuphu.object.User;
import com.example.android_game_app_ailatrieuphu.sqlite.DialogMuaTroGiup;
import com.example.android_game_app_ailatrieuphu.sqlite.MyDatabasehelper;

import java.util.ArrayList;
import java.util.Random;

public class MainGame2Activity extends AppCompatActivity implements DialogMuaTroGiup.OnInputListener {
    ListView lsvTienThuong;
    TienThuongAdapter tienThuongAdapter;
    ArrayList<String> arrTienThuong;
    CauHoi cauHoi;

    int viTriCauHoi = 1;
    View.OnClickListener listener;
    TextView txvCauHoi, txvCauTL1, txvCauTL2, txvCauTL3, txvCauTL4;
    ArrayList<TextView> arrTxvCauTraLoi;
    String cauTraLoi;
    FakeData fakeData;
    String email, password, totalpoint;
    String inputChoice = "";

    SharedPreferences sharedPreferences;
    MediaPlayer mediaPlayer;
    String soundOn;
    private static final String TAG = "MainGame2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game2);
        lsvTienThuong = findViewById(R.id.lsvTienThuong);
        txvCauHoi = findViewById(R.id.txvCauHoi);
        txvCauTL1 = findViewById(R.id.txvCauTL1);
        txvCauTL2 = findViewById(R.id.txvCauTL2);
        txvCauTL3 = findViewById(R.id.txvCauTL3);
        txvCauTL4 = findViewById(R.id.txvCauTL4);


        Bundle mBundle = getIntent().getExtras();
        email = mBundle.getString("email");
        password = mBundle.getString("password");

        sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE);
        soundOn = sharedPreferences.getString("soundOn", "false");
        if (soundOn.equals("true")) {
            playSound();
        } else {
            stopSound();
        }

        MyDatabasehelper dbHelper = new MyDatabasehelper(MainGame2Activity.this);
        User user = dbHelper.queryUser(email, password);
        totalpoint = user.getTotalpoint();
//        totalpoint="1000000";
//        Toast.makeText(MainGame2Activity.this,totalpoint+" "+email,Toast.LENGTH_SHORT).show();

        init();
        setUp();
        setClick();
    }

    public void onBackPressed() {
        Toast.makeText(MainGame2Activity.this, "Không thể trở lại", Toast.LENGTH_SHORT).show();
    }

    public void init() {
        arrTienThuong = new ArrayList<>();
        arrTienThuong.add("1000000");
        arrTienThuong.add("500000");
        arrTienThuong.add("250000");
        arrTienThuong.add("125000");
        arrTienThuong.add("64000");
        arrTienThuong.add("32000");
        arrTienThuong.add("16000");
        arrTienThuong.add("8000");
        arrTienThuong.add("4000");
        arrTienThuong.add("2000");
        arrTienThuong.add("1000");
        arrTienThuong.add("500");
        arrTienThuong.add("300");
        arrTienThuong.add("200");
        arrTienThuong.add("100");

        tienThuongAdapter = new TienThuongAdapter(this, 0, arrTienThuong);

        cauHoi = new CauHoi();

        arrTxvCauTraLoi = new ArrayList<>();
        arrTxvCauTraLoi.add(txvCauTL1);
        arrTxvCauTraLoi.add(txvCauTL2);
        arrTxvCauTraLoi.add(txvCauTL3);
        arrTxvCauTraLoi.add(txvCauTL4);

        fakeData = new FakeData(this);
    }

    public void setUp() {
        lsvTienThuong.setAdapter(tienThuongAdapter);
        hienCauHoi();
    }

    public void setClick() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCauTraLoi(((TextView) view));
            }
        };
        for (TextView t : arrTxvCauTraLoi) {
            t.setOnClickListener(listener);
        }
    }

    public void checkCauTraLoi(final TextView txv) {
        cauTraLoi = txv.getText().toString();
        txv.setBackgroundResource(R.drawable.bg_cau_chon);

        new CountDownTimer(2000, 100) {

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                for (TextView t : arrTxvCauTraLoi) {
                    String s = t.getText().toString();
                    if (s.equals(cauHoi.getDapAnDung())) {
                        t.setBackgroundResource(R.drawable.bg_cau_dung);
                        break;
                    }
                }
                new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long l) {
                    }

                    @Override
                    public void onFinish() {
                        Bundle mBundle = new Bundle();
                        if (cauTraLoi.equals(cauHoi.getDapAnDung())) {
                            viTriCauHoi++;
                            if (viTriCauHoi > 15) {
                                viTriCauHoi = 15;
                                String sEnd = "Chúc mừng bạn đã chiến thắng và trở thành triệu phú với số tiền \n" + arrTienThuong.get(0) + "$";

                                int totalP = Integer.parseInt(totalpoint) + Integer.parseInt(arrTienThuong.get(0));
                                totalpoint = Integer.toString(totalP);

                                final MyDatabasehelper dbHelper = new MyDatabasehelper(MainGame2Activity.this);
                                dbHelper.addPoint(email, totalpoint);
                                dbHelper.insertHistory(email, "+" + arrTienThuong.get(0), "win");

                                mBundle.putString("textEnd", sEnd);
                                mBundle.putString("email", email);
                                mBundle.putString("password", password);
                                Intent i = new Intent(MainGame2Activity.this, EndGameActivity.class);
                                i.putExtras(mBundle);
                                stopSound();
                                startActivity(i);
                                return;
                            }
                            hienCauHoi();
                        } else {
                            int vitriTienThuong = (viTriCauHoi / 5) * 5;
                            String sEnd = "";
                            if (vitriTienThuong < 5) {
                                sEnd = "Bạn sẽ ra về với tiền thưởng là \n" + "0$";

                            } else if (vitriTienThuong < 10) {
                                sEnd = "Ban sẽ ra về với tiền thương là \n" + arrTienThuong.get(10) + "$";

                                int totalP = Integer.parseInt(totalpoint) + Integer.parseInt(arrTienThuong.get(10));
                                totalpoint = Integer.toString(totalP);
                                MyDatabasehelper dbHelper = new MyDatabasehelper(MainGame2Activity.this);
                                dbHelper.addPoint(email, totalpoint);
                                dbHelper.insertHistory(email, "+" + arrTienThuong.get(10), "win");
                            } else {
                                sEnd = "Ban sẽ ra về với tiền thương là \n" + arrTienThuong.get(5) + "$";

                                int totalP = Integer.parseInt(totalpoint) + Integer.parseInt(arrTienThuong.get(5));
                                totalpoint = Integer.toString(totalP);
//                                Toast.makeText(MainGame2Activity.this,totalpoint,Toast.LENGTH_SHORT).show();
                                MyDatabasehelper dbHelper = new MyDatabasehelper(MainGame2Activity.this);
                                dbHelper.addPoint(email, totalpoint);
                                dbHelper.insertHistory(email, "+" + arrTienThuong.get(5), "win");

                            }
                            mBundle.putString("email", email);
                            mBundle.putString("password", password);
                            mBundle.putString("textEnd", sEnd);
                            Intent i = new Intent(MainGame2Activity.this, EndGameActivity.class);
                            i.putExtras(mBundle);
                            stopSound();
                            startActivity(i);
                        }
                    }
                }.start();
            }
        }.start();
    }

    public void setCauHoi() {
        cauHoi = fakeData.taoCauHoi(viTriCauHoi);
    }

    public void hienCauHoi() {
        setCauHoi();
        checkMuaTroGiup = true;
        txvCauHoi.setText(cauHoi.getNoiDung());
        ArrayList<String> arrCauTraLoi = new ArrayList<>(cauHoi.getArrDapAnSai());
        arrCauTraLoi.add(cauHoi.getDapAnDung());
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int vt1 = r.nextInt(arrCauTraLoi.size());
            int vt3 = r.nextInt(arrCauTraLoi.size());
            int vt4 = r.nextInt(arrCauTraLoi.size());
            String a = arrCauTraLoi.get(vt1);
            arrCauTraLoi.set(vt1, arrCauTraLoi.get(vt3));
            arrCauTraLoi.set(vt3, arrCauTraLoi.get(vt4));
            arrCauTraLoi.set(vt4, a);
        }

        for (int i = 0; i < arrTxvCauTraLoi.size(); i++) {
            arrTxvCauTraLoi.get(i).setOnClickListener(listener);
            arrTxvCauTraLoi.get(i).setVisibility(View.VISIBLE);
            arrTxvCauTraLoi.get(i).setBackgroundResource(R.drawable.bg_btn);
            arrTxvCauTraLoi.get(i).setText(arrCauTraLoi.get(i));
        }

        tienThuongAdapter.setViTriCauHoi(viTriCauHoi);
    }

    boolean troGiup5050 = true;
    int vitriCauHoi5050;
    int DapAnAn1 = 0, DapAnAn2 = 0;

    public void trogiup5050(View view) {
        if (troGiup5050 == false) {
            return;
        }
        vitriCauHoi5050 = viTriCauHoi;
        Random r = new Random();
        int sodanAnAnDi = 2;
        do {
            int vitriDanAnAn = r.nextInt(4);
            TextView t = arrTxvCauTraLoi.get(vitriDanAnAn);

            if (t.getVisibility() == View.VISIBLE && t.getText().toString().equals(cauHoi.getDapAnDung()) == false) {
                if (DapAnAn1 == 0) DapAnAn1 = vitriDanAnAn;
                else DapAnAn2 = vitriDanAnAn;
                t.setVisibility(View.INVISIBLE);
                t.setOnClickListener(null);
                sodanAnAnDi--;
            }
        } while (sodanAnAnDi > 0);
        troGiup5050 = false;
    }

    boolean troGiupKhanGia = true;
    int viTriCauHoiKhanGia;

    public void troGiupKhanGia(View view) {
        if (troGiupKhanGia == false) {
            return;
        }
        viTriCauHoiKhanGia = viTriCauHoi;
        if (vitriCauHoi5050 == viTriCauHoiKhanGia) {
            for (int i = 0; i < arrTxvCauTraLoi.size(); i++) {
                TextView t = arrTxvCauTraLoi.get(i);
                if (t.getText().toString().equals(cauHoi.getDapAnDung())) {
                    String conLai = Integer.toString(DapAnAn1) + DapAnAn2;

//                    Toast.makeText(MainGame2Activity.this,conLai,Toast.LENGTH_SHORT).show();

                    new DialogKhanGiaTraLoi(this, i + 1, true, conLai).show();
                    break;
                }
            }
            troGiupKhanGia = false;
            return;
        }
        for (int i = 0; i < arrTxvCauTraLoi.size(); i++) {
            TextView t = arrTxvCauTraLoi.get(i);
            if (t.getText().toString().equals(cauHoi.getDapAnDung())) {
                new DialogKhanGiaTraLoi(this, i + 1).show();
                break;
            }
        }
        troGiupKhanGia = false;
    }

    boolean troGiupDoiCauHoi = true;

    public void trogiupDoiCauHoi(View view) {
        if (troGiupDoiCauHoi == false) {
            return;
        }
        hienCauHoi();
        troGiupDoiCauHoi = false;
    }

//    boolean muaTrogiup = true;

    public void muaTroGiup(View view) {

//        new DialogMuaTroGiup(MainGame2Activity.this).show();
        Log.d(TAG, "onClick: opening dialog.");
        DialogMuaTroGiup dialog = new DialogMuaTroGiup();
        dialog.show(getSupportFragmentManager(), "DialogMuaTroGiup");
    }

    public boolean checkMuaTroGiup = true;

    @Override
    public void sendInput(String input) {
        if (checkMuaTroGiup == false) {
            Toast.makeText(MainGame2Activity.this, "Mỗi câu hỏi chỉ được sử dụng 1 lần", Toast.LENGTH_SHORT).show();
            return;
        }
        if (vitriCauHoi5050 == viTriCauHoi) {
            Toast.makeText(MainGame2Activity.this, "Bạn đã dùng trợ giúp 50-50 ở câu này", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d(TAG, "sendInput: got the input: " + input);
        inputChoice = input;
        int totalP = Integer.parseInt(totalpoint);
//        Toast.makeText(MainGame2Activity.this,inputChoice,Toast.LENGTH_SHORT).show();
        if (inputChoice.equals("1")) {
            if (totalP <= 20000) {
                Toast.makeText(MainGame2Activity.this, "Bạn còn thiếu " + (20000 - totalP), Toast.LENGTH_SHORT).show();
                return;
            }
            checkMuaTroGiup = false;
            totalP = totalP - 20000;
            totalpoint = Integer.toString(totalP);
            final MyDatabasehelper dbHelper = new MyDatabasehelper(MainGame2Activity.this);
            dbHelper.addPoint(email, totalpoint);
            dbHelper.insertHistory(email, "-20000", "Mua trợ giúp");
            Random r = new Random();
            int sodanAnAnDi = 1;
            do {
                int vitriDanAnAn = r.nextInt(4);
                TextView t = arrTxvCauTraLoi.get(vitriDanAnAn);

                if (t.getVisibility() == View.VISIBLE && t.getText().toString().equals(cauHoi.getDapAnDung()) == false) {
                    t.setVisibility(View.INVISIBLE);
                    t.setOnClickListener(null);
                    sodanAnAnDi--;
                }
            } while (sodanAnAnDi > 0);
        }
        if (inputChoice.equals("2")) {
            if (totalP <= 50000) {
                Toast.makeText(MainGame2Activity.this, "Bạn còn thiếu " + (50000 - totalP), Toast.LENGTH_SHORT).show();
                return;
            }
            checkMuaTroGiup = false;
            totalP = totalP - 50000;
            totalpoint = Integer.toString(totalP);
            final MyDatabasehelper dbHelper = new MyDatabasehelper(MainGame2Activity.this);
            dbHelper.addPoint(email, totalpoint);
            dbHelper.insertHistory(email, "-50000", "Mua trợ giúp");
            Random r = new Random();
            int sodanAnAnDi = 2;
            do {
                int vitriDanAnAn = r.nextInt(4);
                TextView t = arrTxvCauTraLoi.get(vitriDanAnAn);

                if (t.getVisibility() == View.VISIBLE && t.getText().toString().equals(cauHoi.getDapAnDung()) == false) {
                    t.setVisibility(View.INVISIBLE);
                    t.setOnClickListener(null);
                    sodanAnAnDi--;
                }
            } while (sodanAnAnDi > 0);
        }
        if (inputChoice.equals("3")) {
            if (totalP <= 10000) {
                Toast.makeText(MainGame2Activity.this, "Bạn còn thiếu " + (10000 - totalP), Toast.LENGTH_SHORT).show();
                return;
            }
            checkMuaTroGiup = false;
            totalP = totalP - 10000;
            totalpoint = Integer.toString(totalP);
            final MyDatabasehelper dbHelper = new MyDatabasehelper(MainGame2Activity.this);
            dbHelper.addPoint(email, totalpoint);
            dbHelper.insertHistory(email, "-10000", "Mua trợ giúp");
            hienCauHoi();
        }
    }

    boolean dungCuocChoi = true;

    public void dungCuocChoi(View view) {
        Bundle mBundle = new Bundle();
        if (viTriCauHoi == 1) {
            String sEnd = "Bạn sẽ ra về với tiền thưởng là \n" + "0$";
            mBundle.putString("textEnd", sEnd);
            mBundle.putString("email", email);
            mBundle.putString("password", password);
            Intent i = new Intent(MainGame2Activity.this, EndGameActivity.class);
            i.putExtras(mBundle);
            stopSound();
            startActivity(i);
        } else {
            String sEnd = "Bạn sẽ ra về với tiền thưởng là \n" + arrTienThuong.get(16 - viTriCauHoi) + "$";

            int totalP = Integer.parseInt(totalpoint) + Integer.parseInt(arrTienThuong.get(16 - viTriCauHoi));
            totalpoint = Integer.toString(totalP);
            final MyDatabasehelper dbHelper = new MyDatabasehelper(MainGame2Activity.this);
            dbHelper.addPoint(email, totalpoint);
            boolean addH=dbHelper.insertHistory("123", "+"+arrTienThuong.get(16-viTriCauHoi), "win");

            if(addH) Toast.makeText(MainGame2Activity.this,"đã thêm",Toast.LENGTH_SHORT).show();

            mBundle.putString("textEnd", sEnd);
            mBundle.putString("email", email);
            mBundle.putString("password", password);
            Intent i = new Intent(MainGame2Activity.this, EndGameActivity.class);
            i.putExtras(mBundle);
            stopSound();
            startActivity(i);
        }
    }

    private void playSound() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(MainGame2Activity.this, R.raw.nhac_hieu_ai_la_trieu_phu_1);
        }
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }

    private void stopSound() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}