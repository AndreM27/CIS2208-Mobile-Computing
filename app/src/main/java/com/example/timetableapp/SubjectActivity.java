package com.example.timetableapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class SubjectActivity extends AppCompatActivity {

    EditText name, code, location, time;
    Button add, update, delete, view;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject); //using the activity_subject.xml layout for the page's front end

        //subject test

        name = findViewById(R.id.name);
        code = findViewById(R.id.code);
        location = findViewById(R.id.location);
        time = findViewById(R.id.time);

        add = findViewById(R.id.insert_subj);
        update = findViewById(R.id.edit_subj);
        delete = findViewById(R.id.delete_subj);
        view = findViewById(R.id.view_subj);
        db = new DBHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String codeTXT = code.getText().toString();
                String locationTXT = location.getText().toString();
                String timeTXT = time.getText().toString();

                Boolean checkinsertdata = db.insertSubjdata(nameTXT, codeTXT, locationTXT, timeTXT);
                if (checkinsertdata == true) {
                    Toast.makeText(SubjectActivity.this, "New subject added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SubjectActivity.this, "New subject failed to be added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = name.getText().toString();
                String codeTXT = code.getText().toString();
                String locationTXT = location.getText().toString();
                String timeTXT = time.getText().toString();

                Boolean checkupdatedata = db.updateSubjdata(nameTXT, codeTXT, locationTXT, timeTXT);
                if (checkupdatedata == true) {
                    Toast.makeText(SubjectActivity.this, "Subject Updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SubjectActivity.this, "Subject failed to update", Toast.LENGTH_SHORT).show();
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String codeTXT = code.getText().toString();
                Boolean checkdeletedata = db.deleteSubjdata(codeTXT);
                if (checkdeletedata == true) {
                    Toast.makeText(SubjectActivity.this, "Subject deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SubjectActivity.this, "Subject failed to be deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getSubjdata();
                if (res.getCount() == 0) {
                    Toast.makeText(SubjectActivity.this, "No subjects", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Subject :" + res.getString(0) + "\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(SubjectActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();


            }
        });
    }

    public void subjectDetails(View view) { // a method that when called switches from the subject activity to the subjectinfo activity
        Intent intent = new Intent(SubjectActivity.this, SubjectInfoActivity.class);
        startActivity(intent); //loads the subjectinfo activity screen
    }
}



