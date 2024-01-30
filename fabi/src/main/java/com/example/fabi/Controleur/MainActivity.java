package com.example.fabi.Controleur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fabi.Model.Session;
import com.example.fabi.R;

public class MainActivity extends AppCompatActivity {

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mSession = new Session(this);
        mUtilisateurTable = new UtilisateurTable(this);
        mPublicationTable = new PublicationTable(this);
        mSQLiteDatabase = openOrCreateDatabase("data.db",MODE_PRIVATE,null);
        mUtilisateurTable.onCreate(mSQLiteDatabase);
        mPublicationTable.onCreate(mSQLiteDatabase);
        mMainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayouttmp,mMainFragment).commit();
        try{
            Toast.makeText(this,mSession.getNumero(),Toast.LENGTH_SHORT);
        }catch (Exception e)
        {
            Intent login = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(login);
            finish();
        }
    }
    private Session mSession;
    private UtilisateurTable mUtilisateurTable;
    private SQLiteDatabase mSQLiteDatabase;
    private PublicationTable mPublicationTable;
    Toolbar mToolbar;
    private MainFragment mMainFragment;


}