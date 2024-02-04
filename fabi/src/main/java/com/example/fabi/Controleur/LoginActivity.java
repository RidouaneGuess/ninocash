package com.example.fabi.Controleur;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.fabi.Model.Session;
import com.example.fabi.R;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        mNumber = findViewById(R.id.editTextNumeroMain);
        mPassword = findViewById(R.id.editTextPasswordMain);
        mLogin = findViewById(R.id.ButtonLogin);
        mNewCompte = findViewById(R.id.id_NewCompte);
        mSession = new Session(this);
        mNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mNumber.setBackground(getResources().getDrawable(R.drawable.forme1));
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mPassword.setBackground(getResources().getDrawable(R.drawable.forme1));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mNumber.getText().toString().equals("")&&mPassword.getText().toString().equals(""))
                {
                    mNumber.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                    mPassword.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                } else if (mNumber.getText().toString().equals("")) {
                    mNumber.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                } else if (mPassword.getText().toString().equals("")) {
                    mPassword.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                }
                else
                {
                    try{
                        Toast.makeText(LoginActivity.this, mSession.getMatricule(), Toast.LENGTH_SHORT);
                        Intent home=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(home);
                        finish();
                    }catch (Exception e)
                    {
                        Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT);
                    }
                }
            }
        });
        mNewCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });
    }
    private EditText mNumber;
    private EditText mPassword;
    private Button mLogin;
    private Button mNewCompte;
    Session mSession;
}