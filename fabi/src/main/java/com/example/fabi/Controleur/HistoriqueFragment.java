package com.example.fabi.Controleur;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fabi.R;

public class HistoriqueFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_historique, container, false);
        mTextViewStatistique = view.findViewById(R.id.text_view_statistique);
        return view;
    }
    private TextView mTextViewStatistique;
}