package com.example.ticketify;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnnoncementAdapter extends RecyclerView.Adapter<AnnoncementAdapter.ViewHolder>{

    private static final String TAG = "AnnocementsViewAdapter";

    //vars
    private ArrayList<String> annoncementList=new ArrayList<>();
    private Context context;

    public AnnoncementAdapter(Context context,ArrayList<String> annoncementList) {
        this.annoncementList = annoncementList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG ," onCreateViewHolder: called");

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_annoncement,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.annoncement.setText(annoncementList.get(position));
    }

    @Override
    public int getItemCount() {
        return annoncementList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView annoncement;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            annoncement= itemView.findViewById(R.id.annoTextView);
        }
    }
}
