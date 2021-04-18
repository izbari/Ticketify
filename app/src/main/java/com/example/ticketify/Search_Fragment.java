package com.example.ticketify;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Search_Fragment extends Fragment implements DatePickerDialog.OnDateSetListener{
    private static final String TAG = "Search_Fragment";

    List cities;
    String[] citiesArr;

    Spinner citySpinnerOneWay1;
    Spinner citySpinnerOneWay2;

    Spinner citySpinnerRound1;
    Spinner citySpinnerRound2;

    TextView dateOneWay;
    TextView dateRound;

    ViewPager2 viewPager2;
    TabLayout tabLayout;
    TabItem oneWay,roundTrip;

    SearchAdapter srcAdapter;
    ViewPager2 myViewpg;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_search,container, false);

        //assign

        //Spinners
        citySpinnerOneWay1= (Spinner) rootView.findViewById(R.id.spinner1);
        citySpinnerOneWay2=(Spinner) rootView.findViewById(R.id.spinner2);
        citySpinnerRound1= (Spinner) rootView.findViewById(R.id.spinner3);
        citySpinnerRound2=(Spinner) rootView.findViewById(R.id.spinner4);

        dateOneWay = (TextView) rootView.findViewById(R.id.date1);
        dateRound = (TextView) rootView.findViewById(R.id.rounddate1);

        //viewPager2 =(ViewPager2) rootView.findViewById(R.id.viewPager2);
        tabLayout= (TabLayout) rootView.findViewById(R.id.mtabLayout);
       // oneWay= (TabItem) rootView.findViewById(R.id.oneWayTab);
       // roundTrip= (TabItem) rootView.findViewById(R.id.roundTripTab);
        myViewpg = rootView.findViewById(R.id.myViewpg);


        //initialize list
        citiesArr=getResources().getStringArray(R.array.cities);
        cities =  Arrays.asList(citiesArr);

        FragmentManager fm= getChildFragmentManager();
        TabsAdapter adapter = new TabsAdapter(fm,getLifecycle());

        myViewpg.setAdapter(adapter);




        return rootView;

    }




    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog= new DatePickerDialog(getContext(),
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();

    }

    public void SpinnerFunc1(){
        ArrayAdapter<String> cityAdapter1 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item,cities);
        cityAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinnerOneWay1.setAdapter(cityAdapter1);

        citySpinnerOneWay1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Choose a city")){

                }

                else{
                    String selectedCity = parent.getItemAtPosition(position).toString();

                    Toast.makeText(parent.getContext(), "Selected city: "+ selectedCity, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void SpinnerFunc2(){
        ArrayAdapter<String> cityAdapter2 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item,cities);
        cityAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinnerOneWay2.setAdapter(cityAdapter2);

        citySpinnerOneWay2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Choose a city")){

                }

                else{
                    String selectedCity = parent.getItemAtPosition(position).toString();

                    Toast.makeText(parent.getContext(), "Selected city: "+ selectedCity, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void SpinnerFunc3(){
        ArrayAdapter<String> cityAdapter3 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item,cities);
        cityAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinnerRound1.setAdapter(cityAdapter3);

        citySpinnerRound1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Choose a city")){

                }

                else{
                    String selectedCity = parent.getItemAtPosition(position).toString();

                    Toast.makeText(parent.getContext(), "Selected city: "+ selectedCity, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void SpinnerFunc4(){
        ArrayAdapter<String> cityAdapter4 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item,cities);
        cityAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinnerRound2.setAdapter(cityAdapter4);

        citySpinnerRound2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Choose a city")){

                }

                else{
                    String selectedCity = parent.getItemAtPosition(position).toString();

                    Toast.makeText(parent.getContext(), "Selected city: "+ selectedCity, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String mdy = month+"/"+dayOfMonth+"/"+year;
        dateOneWay.setText(mdy);

    }
}
