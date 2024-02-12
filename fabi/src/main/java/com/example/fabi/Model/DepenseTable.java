package com.example.fabi.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DepenseTable extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ninocash.db";
    public static final String NAME_TABLE = "Depense";
    public DepenseTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Depense\n" +
                "(\n" +
                "    idDepense INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "    matricule VARCHAR(100) NOT NULL,\n" +
                "    dateDepense VARCHAR(100) NOT NULL,\n" +
                "    montantDepense FLOAT NOT NULL,\n" +
                "    typeDepense VARCHAR(100) NOT NULL,\n" +
                "    categorieDepense VARCHAR(100) NOT NULL,\n" +
                "    descriptionDepense VARCHAR(100) NOT NULL\n" +
                ");");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Depense;");
        onCreate(db);
    }
    public Cursor getData(String matricule)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Depense WHERE matricule=\"" + matricule + "\";",null);
        return res;
    }

    public boolean insert (String matricule , String date,float montant ,String type,String categorie,String description)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("matricule",matricule);
        contentValues.put("dateDepense",date);
        contentValues.put("montantDepense",montant);
        contentValues.put("typeDepense",type);
        contentValues.put("categorieDepense",categorie);
        contentValues.put("descriptionDepense",description);
        db.insert("Depense",null,contentValues);
        return  true;
    }

    public String getDate(String matricule)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT dateDepense FROM Depense WHERE matricule='"+matricule+"';",null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }
    public float getMontant(String matricule)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT montantDepense FROM Depense WHERE matricule='"+matricule+"';",null);
        cursor.moveToFirst();
        return cursor.getFloat(0);
    }
    public String getType(String matricule)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT typeDepense FROM Depense WHERE matricule='"+matricule+"';",null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }
    public String getCategorie(String matricule)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT categorieDepense FROM Depense WHERE matricule='"+matricule+"';",null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }

    public String getMatricule()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT matricule FROM Depense;",null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }
    public String getDescription()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT descriptionDepense FROM depense;",null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }
}

