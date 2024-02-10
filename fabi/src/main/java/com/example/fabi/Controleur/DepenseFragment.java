package com.example.fabi.Controleur;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fabi.Model.Depense;
import com.example.fabi.R;

import java.util.ArrayList;
import java.util.List;

public class DepenseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
              View  view =inflater.inflate(R.layout.fragment_depense, container, false);
              mRecyclerViewDepense = view.findViewById(R.id.recycle_view_depense);
              mDepenseList = new ArrayList<>();
              mDepenseList.add(new Depense("10 fevrier 2024",330,"un ticket rose et deux verts","Resto"));
              mDepenseList.add(new Depense("10 fevrier 2024",330,"un ticket rose et deux verts","Resto"));
              mDepenseList.add(new Depense("10 fevrier 2024",330,"un ticket rose et deux verts","Resto"));
              mDepenseList.add(new Depense("10 fevrier 2024",330,"un ticket rose et deux verts","Resto"));
              mDepenseList.add(new Depense("10 fevrier 2024",330,"un ticket rose et deux verts","Resto"));
              mDepenseList.add(new Depense("10 fevrier 2024",330,"un ticket rose et deux verts","Resto"));
              mDepenseAdapter = new DepenseAdapter(mDepenseList);
              mRecyclerViewDepense.setLayoutManager(new LinearLayoutManager(getContext()));
              mRecyclerViewDepense.setAdapter(mDepenseAdapter);
        return view;
    }
    RecyclerView mRecyclerViewDepense;
    DepenseAdapter mDepenseAdapter;
    List<Depense> mDepenseList;
}