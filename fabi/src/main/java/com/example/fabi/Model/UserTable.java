package com.example.fabi.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserTable extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ninocash.db";
    public static final String NAME_TABLE = "User";
    public UserTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS User\n" +
                "(\n" +
                "    matricule VARCHAR(100) NOT NULL PRIMARY KEY,\n" +
                "    username VARCHAR(100) NOT NULL,\n" +
                "    fullname VARCHAR(100) NOT NULL\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS User;");
        onCreate(db);
    }
    public Cursor getData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM User;",null);
        return res;
    }
    public Cursor getData(String matricule)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM User WHERE matricule='" + matricule + "';",null);
        return res;
    }

    public boolean insert (String matricule , String username , String fullname)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("matricule",matricule);
        db.insert("User",null,contentValues);
        return  true;
    }
}

