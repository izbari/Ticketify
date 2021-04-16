package com.example.ticketify;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;

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
    private TextView anno1;
    private TextView anno2;
    private TextView anno3;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter discountAdapter;
    private RecyclerView.LayoutManager rvLayoutManager;
    private ArrayList<Discount> discountEntries;
    private ArrayList<String> annoEntries;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    HorizontalScrollView scrollview;
    int var = 0;

    public Home_Fragment() {
        // empty  constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        annoEntries();
        discountEntries();


        scrollview = rootView.findViewById(R.id.horizontalScrollView);
        anno1 = rootView.findViewById(R.id.anno1);
        anno2 = rootView.findViewById(R.id.anno2);
        anno3 = rootView.findViewById(R.id.anno3);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        rvLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(rvLayoutManager);


        recursive();

        return rootView;
    }


    public void recursive() {
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
    }


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
                recyclerView.setAdapter(discountAdapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Home_Fragment", "loadLog:onCancelled", databaseError.toException());
            }
        });

    }

    private void annoEntries() {
        annoEntries = new ArrayList<>();
        DatabaseReference myRef = db.getReference("announcements");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    annoEntries.add(data.getValue().toString());

                }
                anno1.setText(annoEntries.get(0));
                anno2.setText(annoEntries.get(1));
                anno3.setText(annoEntries.get(2));


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("Home_Fragment", "loadLog:onCancelled", databaseError.toException());
            }
        });

    }


}