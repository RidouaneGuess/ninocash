package com.example.fabi.Controleur;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.fabi.Model.Session;
import com.example.fabi.R;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SuggestionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        getSupportActionBar().hide();
        // StatusBarCusto statusBarCusto = new StatusBarCusto(this,getWindow());
        // Activer le bouton de retour de l'action barre
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mSession = new Session(this);
        mEnvoyerSuggestion = findViewById(R.id.EnvoyerJuggestion);
        mObjetJuggestion = findViewById(R.id.ObjetsJuggestion);
        mSuggestion = findViewById(R.id.Suggestion);
        mErr = findViewById(R.id.TextErrSugg);
        mPhone = findViewById(R.id.infoPhone);
        mCirculaire = findViewById(R.id.progress_circularSuggestion);
        mModel = Build.MODEL;
        mVersion = Build.VERSION.RELEASE;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.options_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mObjetJuggestion.setAdapter(adapter);
    }

    private Button mEnvoyerSuggestion;
    private EditText mSuggestion;
    private Session mSession;
    private Spinner mObjetJuggestion;
    private TextView mErr;
    private String mModel;
    private String mVersion;
    private CheckBox mPhone;
    private ProgressBar mCirculaire;
}