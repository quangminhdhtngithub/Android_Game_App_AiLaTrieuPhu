package com.example.android_game_app_ailatrieuphu;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_game_app_ailatrieuphu.object.User;
import com.example.android_game_app_ailatrieuphu.sqlite.MyDatabasehelper;

public class MainGameActivity extends AppCompatActivity {
    Button btnBatDau, btnHuongDan, btnOther, btnDangXuat;
    TextView txtDiem;
    SharedPreferences sharedPreferences;
    MediaPlayer mediaPlayer;
    String soundOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        btnBatDau = findViewById(R.id.btnBatDau);
        btnHuongDan = findViewById(R.id.btnHuongDan);
        btnOther = findViewById(R.id.btnOther);
        btnDangXuat = findViewById(R.id.btnDangXuat);
        txtDiem = findViewById(R.id.txtDiem);

        Bundle mBundle = getIntent().getExtras();
        final String email = mBundle.getString("email","");
        final String password = mBundle.getString("password");

        sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE);
        soundOn = sharedPreferences.getString("soundOn", "false");
//        soundOn="true";
        if (soundOn.equals("true")) {
            playSound();
        } else {
            stopSound();
        }

        MyDatabasehelper dbHelper = new MyDatabasehelper(this);
        User user = dbHelper.queryUser(email, password);
        txtDiem.setText("Điểm của bạn: " + user.getTotalpoint());

        btnBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle mBundle = new Bundle();
                mBundle.putString("email", email);
                mBundle.putString("password", password);
                Intent i = new Intent(MainGameActivity.this, MainGame2Activity.class);
                i.putExtras(mBundle);
                stopSound();
//                finish();
                startActivity(i);

            }
        });
        btnHuongDan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ihd = new Intent(MainGameActivity.this, HuongDan.class);
//                finish();
                stopSound();
                startActivity(ihd);
            }
        });
        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle mBundle = new Bundle();
                mBundle.putString("email", email);
                Intent i = new Intent(MainGameActivity.this, OtherActivity.class);
                i.putExtras(mBundle);
                stopSound();
//                finish();
                startActivity(i);


            }
        });
//        btnDangXuat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainGameActivity.this, LoginActivity.class);
////                finish();
//                startActivity(intent);
//                stopSound();
//            }
//        });
    }

    private void playSound() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(MainGameActivity.this, R.raw.nhac_hieu_ai_la_trieu_phu);
        }
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }

    private void stopSound() {
        if (mediaPlayer != null) {
//            mediaPlayer.release();
//            mediaPlayer = null;
            mediaPlayer.stop();
        }
    }

    @Override
    protected void onRestart() {
        this.recreate();
        super.onRestart();
    }

    public void onBackPressed() {
        Toast.makeText(MainGameActivity.this, "Không thể trở lại", Toast.LENGTH_SHORT).show();
    }
}