package com.example.timetableapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.timetableapp.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private AppBarConfiguration mAppBarConfiguration;




    //drawer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//drawer
        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);

            }
        });

//navigation
        NavigationView navigationView = findViewById(R.id.navigationView);
        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);

/*
        final Button profile = findViewById(R.id.nav_profile);
        profile.setOnClickListener(new View.OnClickListener() { //method that handles button clicks
            @Override
            public void onClick(View v) { //defines what to do when the button is clicked

                //loginViewModel.login(usernameEditText.getText().toString(),
                //passwordEditText.getText().toString())
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class); //linking the login page to the subjects page
                startActivity(intent); //starting the subject's page intent, when the sign in or register button is clicked
            }
        });
   */
        //Upload image
        if (navigationView.equals(R.id.nav_profile)) {
            setContentView(R.layout.fragment_profile);
            Intent prof = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(prof);
        }

        //Subject
        //if (navigationView.equals(R.id.nav_subjects)) {
          //  Intent subj = new Intent(MainActivity.this, SubjectActivity.class);
            //startActivity(subj);
        //}





    }

}