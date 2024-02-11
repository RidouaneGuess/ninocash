package com.example.fabi.Controleur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabi.Model.Session;
import com.example.fabi.Model.UserTable;
import com.example.fabi.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();


        /* Initialisation des attributs menbre */
        mEditMatricule = findViewById(R.id.EditMatricule);
        mEditMail = findViewById(R.id.EditMail);
        mEditPasse = findViewById(R.id.EditPasse);
        mEditConf = findViewById(R.id.EditConfirmer);
        mButtonConnect = findViewById(R.id.ButtonConnect2);
        mTextLogin = findViewById(R.id.TextLogin);
        mTextErr2 = findViewById(R.id.TextErr2);
        mEditTextNom = findViewById(R.id.EditNom);
        mEditTextPrenom = findViewById(R.id.EditPrenom);
        mSession = new Session(this);
        mUser = new UserTable(this);
        mDb = openOrCreateDatabase("ninocash.db",MODE_PRIVATE,null);
        mUser.onCreate(mDb);
        mSession.onCreate(mDb);
        /* En cliquant sur le boutton de connection2 */
        mButtonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mEditMatricule.getText().toString().equals("") && mEditMail.getText().toString().equals("") && mEditPasse.getText().toString().equals("") && mEditConf.getText().toString().equals("") && mEditTextNom.getText().toString().equals("") && mEditTextPrenom.getText().toString().equals(""))
                {
                    mTextErr2.setText("Veuillez remplir ces champs svp");
                    mEditMatricule.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                    mEditMail.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                    mEditPasse.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                    mEditConf.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                    mEditTextNom.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                    mEditTextPrenom.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                }
                else
                {
                    if(mEditMatricule.getText().toString().equals(""))
                    {
                        mTextErr2.setText("Votre matricule svp");
                        mEditMatricule.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                        mEditMail.setBackground(getResources().getDrawable(R.drawable.form_white_raduis_10dp));
                        mEditPasse.setBackground(getResources().getDrawable(R.drawable.form_white_raduis_10dp));
                        mEditConf.setBackground(getResources().getDrawable(R.drawable.form_white_raduis_10dp));
                    }
                    if(mEditTextNom.getText().toString().equals(""))
                    {
                        mTextErr2.setText("Votre Nom svp");
                        mEditTextNom.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                    }
                    if(mEditTextPrenom.getText().toString().equals(""))
                    {
                        mTextErr2.setText("Votre Prénom svp");
                        mEditTextPrenom.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                    }
                    if(mEditMail.getText().toString().equals(""))
                    {
                        mTextErr2.setText("Votre Email svp");
                        mEditMail.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                    }
                    if(!mEditMatricule.getText().toString().equals("") && !mEditMail.getText().toString().equals("") && !mEditPasse.getText().toString().equals("") && !mEditConf.getText().toString().equals("") && !mEditTextNom.getText().toString().equals("") && !mEditTextPrenom.getText().toString().equals(""))
                    {
                        if(mEditPasse.getText().toString().equals(mEditConf.getText().toString()))
                        {
                            try{
                                mUser.insert(mEditMatricule.getText().toString(),mEditTextNom.getText().toString(),mEditTextPrenom.getText().toString());
                            }catch (Exception e)
                            {
                                Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                            try{
                                mSession.insert(mEditMatricule.getText().toString());
                            }catch (Exception e)
                            {
                                Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                            Intent main = new Intent(RegisterActivity.this,MainActivity.class);
                            main.putExtra("Nom",mEditTextNom.getText().toString());
                            main.putExtra("Prenom",mEditTextPrenom.getText().toString());
                            startActivity(main);
                            finish();
                        }else
                        {
                            mTextErr2.setText("Erreur de confirmation");
                            mEditMatricule.setBackground(getResources().getDrawable(R.drawable.form_white_raduis_10dp));
                            mEditMail.setBackground(getResources().getDrawable(R.drawable.form_white_raduis_10dp));
                            mEditPasse.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                            mEditConf.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                        }
                    }

                }
            }
        });

        /* En cliquant sur le TextView ce connecter */
        mTextLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(login);
            }
        });
    }
    private EditText mEditMatricule;
    private EditText mEditPasse;
    private EditText mEditConf;
    private Button mButtonConnect;
    private TextView mTextLogin;
    private TextView mTextErr2;
    private EditText mEditMail;
    private SQLiteDatabase mDb;
    private UserTable mUser;
    private Session mSession;
    private EditText mEditTextNom;
    private EditText mEditTextPrenom;
}