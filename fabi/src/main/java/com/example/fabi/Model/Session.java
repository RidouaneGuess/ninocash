package com.example.fabi.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Session extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME = "ninocash.db";
    public static final String NAME_TABLE="Session";
    public Session(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Session\n" +
                "(\n" +
                "    matricule VARCHAR(100) PRIMARY KEY\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Session");
        onCreate(sqLiteDatabase);
    }
    public String getMatricule()
    {
       SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT matricule FROM Session",null);
       cursor.moveToFirst();
       return cursor.getString(0);
    }
    public boolean insert(String matricule)
    {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("matricule",matricule);
            db.insert("Session",null,contentValues);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}
