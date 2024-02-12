package com.example.fabi.Controleur;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fabi.Model.Depense;
import com.example.fabi.Model.DepenseTable;
import com.example.fabi.Model.RevenuTable;
import com.example.fabi.Model.Session;
import com.example.fabi.R;

import java.util.ArrayList;
import java.util.List;

public class DepenseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
              View  view =inflater.inflate(R.layout.fragment_depense, container, false);
              mSession = new Session(getContext());
              mDepenseTable = new DepenseTable(getContext());
              mRevenuTable = new RevenuTable(getContext());
              mRecyclerViewDepense = view.findViewById(R.id.recycle_view_depense);
              mDepenseList = new ArrayList<>();
              // Affichage des depenses dans la list
               // try {
//                    Cursor cursor = mRevenuTable.getData(mSession.getMatricule());
//                    cursor.moveToFirst();
//                    try {
//                        Toast.makeText(getContext(),cursor.getString(2), Toast.LENGTH_SHORT).show();
//                    }catch (Exception e)
//                    {
//                        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }

                    //mDepenseList.add(new Depense(cursor.getString(2),cursor.getFloat(3),cursor.getString(6), cursor.getString(5)));
//                    do
//                    {
//                                mDepenseList.add(new Depense(cursor.getString(2),cursor.getFloat(3),cursor.getString(6), cursor.getString(5)));
//                    }while(cursor.moveToNext());
                    mDepenseAdapter = new DepenseAdapter(mDepenseList);
                    mRecyclerViewDepense.setLayoutManager(new LinearLayoutManager(getContext()));
                    mRecyclerViewDepense.setAdapter(mDepenseAdapter);
//                }catch (Exception e)
//                {
//                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
              mDepenseAdapter = new DepenseAdapter(mDepenseList);
              mRecyclerViewDepense.setLayoutManager(new LinearLayoutManager(getContext()));
              mRecyclerViewDepense.setAdapter(mDepenseAdapter);
        return view;
    }
    RecyclerView mRecyclerViewDepense;
    DepenseAdapter mDepenseAdapter;
    List<Depense> mDepenseList;
    private Session mSession;
    private DepenseTable mDepenseTable;
    private RevenuTable mRevenuTable;
}