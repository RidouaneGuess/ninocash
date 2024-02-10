package com.example.fabi.Controleur;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabi.Model.AccountTable;
import com.example.fabi.Model.Depense;
import com.example.fabi.Model.Session;
import com.example.fabi.Model.ViewPagerAdapter;
import com.example.fabi.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mViewPager2 =view.findViewById(R.id.viewPager);
        mTabLayoutHome = view.findViewById(R.id.tablayout_home);
        mViewPagerAdapter = new ViewPagerAdapter(this);
        mViewPager2.setAdapter(mViewPagerAdapter);
        new TabLayoutMediator(mTabLayoutHome,mViewPager2,(tab, position) -> {
            switch (position)
            {
                case 0:
                    tab.setText("Dépences");
                    break;
                case 1:
                    tab.setText("Revenus");
                    break;
            }
        }).attach();
        return view;
    }

    private TabLayout mTabLayoutHome;
    private ViewPagerAdapter mViewPagerAdapter; //un adaptateur(classe) qu'on va donner au containeur pour permettre le basculement des tabs
    private ViewPager2 mViewPager2;//adaptateur(classe) qu'on va donner au containeur pour permettre le basculement des tabs
}