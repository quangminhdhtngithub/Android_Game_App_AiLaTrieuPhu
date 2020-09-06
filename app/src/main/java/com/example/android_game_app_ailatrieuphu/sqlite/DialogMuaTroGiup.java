package com.example.android_game_app_ailatrieuphu.sqlite;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.android_game_app_ailatrieuphu.R;

public class DialogMuaTroGiup extends DialogFragment {
    private static final String TAG = "MyCustomDialog";


    public interface OnInputListener{
        void sendInput(String input);
    }
    public OnInputListener mOnInputListener;

    //widgets
//    private EditText mInput;
    private Button btnLoaiMotCauSai, btnLoaiHaiCauSai, btnDoiCauHoi;


    //vars

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dialog_mua_tro_giup, container, false);
        btnLoaiMotCauSai = view.findViewById(R.id.btnLoaiMotCauSai);
        btnLoaiHaiCauSai = view.findViewById(R.id.btnLoaiHaiCauSai);
        btnDoiCauHoi = view.findViewById(R.id.btnDoiCauHoi);

        btnLoaiMotCauSai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = "1";
                mOnInputListener.sendInput(input);
                getDialog().dismiss();
            }
        });


        btnLoaiHaiCauSai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d(TAG, "onClick: capturing input");
                String input = "2";
                mOnInputListener.sendInput(input);
                getDialog().dismiss();
            }
        });

        btnDoiCauHoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = "3";
                mOnInputListener.sendInput(input);
                getDialog().dismiss();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mOnInputListener = (OnInputListener) getActivity();
        }catch (ClassCastException e){
            Log.e(TAG, "onAttach: ClassCastException: " + e.getMessage() );
        }
    }
}

