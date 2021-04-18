package com.example.ticketify;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class Home_Fragment extends Fragment {

    private RecyclerView discountRecyclerView;
    private RecyclerView annoRecyclerView;

    private RecyclerView.Adapter discountAdapter;
    private RecyclerView.Adapter annoAdapter;

    private RecyclerView.LayoutManager discountRvLayoutManager;
    private RecyclerView.LayoutManager annoRvLayoutManager;

    private ArrayList<Discount> discountEntries;
    private ArrayList<String> annoEntries;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();


    public Home_Fragment() {
        // empty  constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        annoEntries();
        discountEntries();


        //init discountRecyclerView
        discountRecyclerView = (RecyclerView) rootView.findViewById(R.id.discountRecyclerView);
        discountRvLayoutManager = new LinearLayoutManager(getActivity());
        discountRecyclerView.setLayoutManager(discountRvLayoutManager);

        //init annoncementRecyclerView
        annoRecyclerView = (RecyclerView) rootView.findViewById(R.id.annoRecyclerView);
        annoRvLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        annoRecyclerView.setLayoutManager(annoRvLayoutManager);

       // recursive();

        return rootView;
    }


   /* public void recursive() {
        var = 0;
        new CountDownTimer(10500, 3) {


            public void onTick(long millisUntilFinished) {

                scrollview.scrollTo(var, 0); // from zero to 2000
                var += 1;
            }

            public void onFinish() {
                scrollview.fullScroll(ScrollView.FOCUS_LEFT);
                recursive();
            }


        }.start();
    }*/

    // Recieve data from database
    private void discountEntries() {
        discountEntries = new ArrayList<>();
        DatabaseReference myRef = db.getReference("discounts");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    discountEntries.add(new Discount(data.child("title").getValue().toString(),
                            data.child("description").getValue().toString(), data.child("image").getValue().toString()));

                }

                discountAdapter = new DiscountAdapter(discountEntries);
                discountRecyclerView.setAdapter(discountAdapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Home_Fragment", "loadLog:onCancelled", databaseError.toException());
            }
        });

    }

    // Recieve data from database
    private void annoEntries() {
        annoEntries = new ArrayList<>();
        DatabaseReference myRef = db.getReference("announcements");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    annoEntries.add(data.getValue().toString());

                }

                annoAdapter = new AnnoncementAdapter(getContext(),annoEntries);
                annoRecyclerView.setAdapter(annoAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Home_Fragment", "loadLog:onCancelled", databaseError.toException());
            }
        });

    }


}