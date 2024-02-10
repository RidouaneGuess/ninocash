package com.example.fabi.Controleur;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fabi.Model.Depense;
import com.example.fabi.Model.Revenu;
import com.example.fabi.R;

import java.util.ArrayList;
import java.util.List;

public class RevenuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view =inflater.inflate(R.layout.fragment_revenu, container, false);
        mRecyclerViewRevenu = view.findViewById(R.id.recycle_view_revenu);
        mRevenuList = new ArrayList<>();
        mRevenuList.add(new Revenu("10 fevrier 2024",1000,"Maintenance","Client"));
        mRevenuList.add(new Revenu("11 fevrier 2024",2000,"Maintenance","Client"));
        mRevenuList.add(new Revenu("11 fevrier 2024",3000,"Maintenance","Client"));
        mRevenuList.add(new Revenu("11 fevrier 2024",4000,"Maintenance","Client"));
        mRevenuAdapter = new RevenuAdapter(mRevenuList);
        mRecyclerViewRevenu.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerViewRevenu.setAdapter(mRevenuAdapter);
        return view;
    }
    RecyclerView mRecyclerViewRevenu;
    RevenuAdapter mRevenuAdapter;
    List<Revenu> mRevenuList;
}