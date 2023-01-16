package com.example.infographcar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class
homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationview;
    Toolbar toolbars;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        toolbars = findViewById(R.id.toolbar);
        setSupportActionBar(toolbars);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationview = findViewById(R.id.nav_view);
        navigationview.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbars, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new fragment_homemenu()).commit();
            navigationview.setCheckedItem(R.id.main_home);
        }



    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()){
           case R.id.main_home:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new fragment_homemenu()).commit();
               toolbars.setTitle("Home");
               break;
           case R.id.menu_aboutme:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new fragment_aboutme1()).commit();
               toolbars.setTitle("About Me");
               break;
           case R.id.menu_credits:
               Toast.makeText(this,"Credits havent listed", Toast.LENGTH_SHORT).show();
               break;

           case R.id.menu_carlist:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new fragment_carlist()).commit();
               toolbars.setTitle("Car List");
               break;
           case R.id.menu_mode:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new popularcar()).commit();
               toolbars.setTitle("Popular Car");
               break;
           case R.id.menu_maps:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new cartuning()).commit();
               toolbars.setTitle("Car Tuning");
               break;
           case R.id.menu_history:
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                       new history()).commit();
               toolbars.setTitle("History");
               break;

       }

       drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }
}