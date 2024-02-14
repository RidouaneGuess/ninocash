package com.example.fabi.Controleur;

import android.app.Activity;
import android.app.Dialog;

import com.example.fabi.R;

public class DeconnexionDialog extends Dialog {
    public DeconnexionDialog(Activity activity)
    {
        super(activity, R.style.Dialog_Ninocash);
        setContentView(R.layout.dialog_deconnecter);
    }
    public void build(){show();}
}
