package com.example.fabi.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RevenuTable extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ninocash.db";
    public static final String NAME_TABLE = "Revenu";
    public RevenuTable(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Revenu\n" +
                "(\n" +
                "    idRevenu INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "    matricule VARCHAR(100) NOT NULL,\n" +
                "    dateRevenu VARCHAR(100) NOT NULL,\n" +
                "    montantRevenu FLOAT NOT NULL,\n" +
                "    typeRevenu VARCHAR(100) NOT NULL,\n" +
                "    sourceRevenu VARCHAR(100) NOT NULL,\n" +
                "    descriptionRevenu VARCHAR(100) NOT NULL\n" +
                ");");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Revenu;");
        onCreate(db);
    }
    public Cursor getData(String matricule)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Revenu WHERE matricule='" + matricule + "';",null);
        return res;
    }

    public boolean insert (String matricule , String date,float montant ,String type,String source,String description)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("matricule",matricule);
        contentValues.put("dateRevenu",date);
        contentValues.put("montantRevenu",montant);
        contentValues.put("typeRevenu",type);
        contentValues.put("sourceRevenu",source);
        contentValues.put("descriptionRevenu",description);
        db.insert("Revenu",null,contentValues);
        return  true;
    }

    public String getDate(String matricule)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT dateRevenu FROM Revenu WHERE matricule='"+matricule+"';",null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }
    public float getMontant(String matricule)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT montantRevenu FROM Revenu WHERE matricule='"+matricule+"';",null);
        cursor.moveToFirst();
        return cursor.getFloat(0);
    }
    public String getType(String matricule)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT typeRevenu FROM Revenu WHERE matricule='"+matricule+"';",null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }
    public String getSource(String matricule)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT sourceRevenu FROM Revenu WHERE matricule='"+matricule+"';",null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }

    public String getMatricule()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT matricule FROM Revenu;",null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }
    public String getDescription()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT descriptionRevenu FROM Revenu;",null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }
}

