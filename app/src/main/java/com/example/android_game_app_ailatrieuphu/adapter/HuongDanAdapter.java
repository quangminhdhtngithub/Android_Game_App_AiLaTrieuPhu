package com.example.android_game_app_ailatrieuphu.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android_game_app_ailatrieuphu.R;

import java.util.ArrayList;
import java.util.List;

public class HuongDanAdapter extends ArrayAdapter<String> {
    Context ct;
    ArrayList<String> arr;

    public HuongDanAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_huong_dan,null);
        }
        if(arr.size()>0){
            TextView txvHuongDan = convertView.findViewById(R.id.txvHuongDan);
            txvHuongDan.setTextColor(Color.parseColor("#FFFFFF"));
            txvHuongDan.setText(arr.get(position));
        }
        return convertView;
    }
}
