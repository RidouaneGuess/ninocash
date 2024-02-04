package com.example.fabi.Controleur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabi.Model.Session;
import com.example.fabi.Model.UserTable;
import com.example.fabi.R;

public class MainActivity extends AppCompatActivity {

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mTextView = findViewById(R.id.ninocash);
        mSession = new Session(this);
        mSQLiteDatabase = openOrCreateDatabase("data.db",MODE_PRIVATE,null);
        mUserTable = new UserTable(this);
        mUserTable.onCreate(mSQLiteDatabase);
        /* Ouverteur de la session si ca existe  si non lancement de la page login */
        try {
            Toast.makeText(this, mSession.getMatricule(), Toast.LENGTH_SHORT);
        }
        catch (Exception e)
        {
            Intent login = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(login);
            finish();
        }
  }
    private TextView mTextView;
    private SQLiteDatabase mSQLiteDatabase;
    private UserTable mUserTable;
    private Session mSession;
}