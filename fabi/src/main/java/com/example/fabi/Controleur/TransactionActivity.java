package com.example.fabi.Controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabi.Model.AccountTable;
import com.example.fabi.Model.Depense;
import com.example.fabi.Model.DepenseTable;
import com.example.fabi.Model.Revenu;
import com.example.fabi.Model.RevenuTable;
import com.example.fabi.Model.Session;
import com.example.fabi.R;

public class TransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        mSession = new Session(this);
        mSpinnerCategorie = findViewById(R.id.spinner_categorie_transaction);
        mSpinnerType = findViewById(R.id.spinner_type_transaction);
        mEditTextMontant = findViewById(R.id.edit_montant_transaction);
        mEditTextDescription = findViewById(R.id.edit_description_transaction);
        mEditTextSource = findViewById(R.id.edit_source_transaction);
        mDatePicker = findViewById(R.id.date_picker_transaction);
        mButtonAddTransaction = findViewById(R.id.button_add_transaction);
        mTextViewMessage = findViewById(R.id.message_sortie);
        mAccountTable = new AccountTable(this);
        mRevenuTable = new RevenuTable(this);
        mDepenseTable = new DepenseTable(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categorie_transaction, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerCategorie.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.type_transaction, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerType.setAdapter(adapter2);
        mButtonAddTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mSpinnerCategorie.getSelectedItem().toString().equals("")&&!mSpinnerType.getSelectedItem().equals("")&&!mEditTextMontant.getText().toString().equals("")&&!mEditTextDescription.getText().toString().equals("")&&!mEditTextSource.getText().toString().equals(""))
                {
                    if(mSpinnerCategorie.getSelectedItem().equals("Depense"))
                    {
                        try{
                            mDepenseTable.insert(mSession.getMatricule(),"11 féb 2024",123,mSpinnerType.getSelectedItem().toString(),mSpinnerCategorie.getSelectedItem().toString(),mEditTextDescription.getText().toString());
                            mTextViewMessage.setBackground(getResources().getDrawable(R.drawable.forme_valide));
                            mTextViewMessage.setText("Depense ajoutée avec succès");
                        }catch (Exception e)
                        {
                            mTextViewMessage.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                            mTextViewMessage.setText("Depense non ajoutée");
                        }
                    } else if (mSpinnerCategorie.getSelectedItem().equals("Révenu")) {
                        try{
                            mRevenuTable.insert(mSession.getMatricule(),"11 féb 2024",123,mSpinnerType.getSelectedItem().toString(),mEditTextSource.getText().toString(),mEditTextDescription.getText().toString());
                            mTextViewMessage.setBackground(getResources().getDrawable(R.drawable.forme_valide));
                            mTextViewMessage.setText("Revenu ajouté avec succès");
                        }catch (Exception e)
                        {
                            mTextViewMessage.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                            mTextViewMessage.setText("Révenu non ajouté");
                        }
                    }
                }
                else {
                    mTextViewMessage.setBackground(getResources().getDrawable(R.drawable.forme_erreur));
                    mTextViewMessage.setText("Veuillez Remplir tout les champs!!");
                }
            }
        });
    }
    private Spinner mSpinnerCategorie;
    private Spinner mSpinnerType;
    private EditText mEditTextMontant;
    private DatePicker mDatePicker;
    private EditText mEditTextDescription;
    private EditText mEditTextSource;
    private Session mSession;
    private Button mButtonAddTransaction;
    private DepenseTable mDepenseTable;
    private RevenuTable mRevenuTable;
    private AccountTable mAccountTable;
    private TextView mTextViewMessage;
}