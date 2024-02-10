package com.example.fabi.Model;

import static java.lang.Float.parseFloat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AccountTable extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ninocash.db";
    public static final String NAME_TABLE = "Account";
    public AccountTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Account\n" +
                "(\n" +
                "    idAccount INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "    matriculeUser VARCHAR(100) NOT NULL,\n" +
                "    accountName VARCHAR(100) NOT NULL,\n" +
                "    accountType VARCHAR(100) NOT NULL,\n" +
                "    balance FLOAT NOT NULL\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Account;");
        onCreate(db);
    }
    public Cursor getData(String matricule)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Account WHERE matriculeUser='" + matricule + "';",null);
        return res;
    }

    public boolean insert (String account_name , String matricule,String account_type , float balance)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("accountName",account_name);
        contentValues.put("matriculeUser",matricule);
        contentValues.put("accountType",account_type);
        contentValues.put("balance",balance);
        db.insert("Account",null,contentValues);
        return  true;
    }
    public boolean crediter(String matricule,float montant)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        float mont= (float) (getBalance()+montant);
        contentValues.put("balance",mont);
        db.update("Account",contentValues,"matriculeUser = ?",new String[]{matricule});
        return true;
    }
    public boolean debiter(String matricule,float montant)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        float mont= (float) (getBalance()-montant);
        contentValues.put("balance",mont);
        db.update("Account",contentValues,"matriculeUser = ?",new String[]{matricule});
        return true;
    }
    public String getBalance(String matricule)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT balance FROM Account WHERE matriculeUser='"+matricule+"';",null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }
    public float getBalance()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT balance FROM Account;",null);
        cursor.moveToFirst();
        return cursor.getFloat(0);
    }
    public String getMatricule()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT matriculeUser FROM Account;",null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }
}

