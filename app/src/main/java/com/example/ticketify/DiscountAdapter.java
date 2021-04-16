package com.example.ticketify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class DiscountAdapter extends RecyclerView.Adapter<DiscountAdapter.MyViewHolder> {

    private ArrayList<Discount> entries;

    public DiscountAdapter(ArrayList<Discount> entries){
        this.entries = entries;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_discounts, null);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(entries.get(position).getTitle());
        holder.description.setText(entries.get(position).getDescription());
        Picasso.get().load(entries.get(position).getImgURL()).into(holder.imgIcon);
    }


    @Override
    public int getItemCount() {
        return entries.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, description;
        ImageView imgIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.başlık);
            description = (TextView) itemView.findViewById(R.id.acıklama);
            imgIcon = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
