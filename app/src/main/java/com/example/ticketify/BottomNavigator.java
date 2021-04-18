package com.example.ticketify;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BottomNavigator extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigator);


         BottomNavigationView bottomNavigation = findViewById(R.id.navigationbar);
         bottomNavigation.setOnNavigationItemSelectedListener(navListener);
         getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                            ,new Home_Fragment()).commit();

    }



      private  BottomNavigationView.OnNavigationItemSelectedListener navListener =
              new BottomNavigationView.OnNavigationItemSelectedListener() {
                  @Override
                  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                      Fragment selectedFragment = null;
                      
                      switch (item.getItemId()){
                          case R.id.nav_home:
                              selectedFragment = new Home_Fragment();
                              break;
                          case R.id.nav_search:
                              selectedFragment = new Search_Fragment();
                              break;
                          case R.id.nav_ticket:
                              selectedFragment = new MyTicket_Fragment();
                              break;
                          case R.id.nav_help:
                              selectedFragment = new Help_Fragment();
                              break;
                          case R.id.nav_account:
                              selectedFragment = new Account_Fragment();
                              break;


                      }
                      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                              selectedFragment).commit();
                      return true;
                  }
              };
}