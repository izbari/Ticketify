package com.example.ticketify;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;



public class DiscountAdapter extends ArrayAdapter<discounts> {
    private ArrayList<discounts> list;

    public DiscountAdapter(@NonNull Context context, int resource,ArrayList<discounts> list) {
        super(context, resource,list);
        this.list=list;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int phraseIndex =position;
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.discounts,parent,false);
        }
        ImageView images =convertView.findViewById(R.id.img);
        TextView title = convertView.findViewById(R.id.başlık);
        TextView description = convertView.findViewById(R.id.acıklama);

        images.setImageResource(list.get(position).getImgID());
        title.setText(list.get(position).getTitle());
        description.setText(list.get(position).getDescription());
        return convertView;

    }
}
