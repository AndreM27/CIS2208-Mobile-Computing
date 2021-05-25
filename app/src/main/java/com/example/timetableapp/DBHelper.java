package com.example.timetableapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Subjectdetails(name TEXT, code TEXT primary key, location TEXT,time TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Subjectdetails");

    }

    public Boolean insertSubjdata(String name, String code, String location, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("code", code);
        contentValues.put("location", location);
        contentValues.put("time", time);
        long result = db.insert("Subjectdetails", null, contentValues);
        //if insertion fails
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateSubjdata(String name, String code, String location, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("location", location);
        contentValues.put("time", time);

        Cursor cursor = db.rawQuery("select * from SubjectDetails where code = ?", new String[]{code});
        if (cursor.getCount() > 0) {

            long result = db.update("Subjectdetails", contentValues, "code=?", new String[]{code});
            //if insertion fails
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteSubjdata(String code) {
        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cursor = db.rawQuery("select * from SubjectDetails where code = ?", new String[]{code});
        if (cursor.getCount() > 0) {

            long result = db.delete("Subjectdetails", "code=?", new String[]{code});
            //if insertion fails
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getSubjdata()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from SubjectDetails", null);
        return cursor;
    }
}


