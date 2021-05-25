package com.example.timetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SubjectInfoActivity extends AppCompatActivity { //the class that handles the subject details

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_info); //using the layout of the subject_info.xml file for the front end
    }
}