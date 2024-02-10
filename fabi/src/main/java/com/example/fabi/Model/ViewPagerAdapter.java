package com.example.fabi.Model;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.fabi.Controleur.DepenseFragment;
import com.example.fabi.Controleur.HomeFragment;
import com.example.fabi.Controleur.RevenuFragment;


public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(Fragment fragment) {super(fragment);}

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new DepenseFragment();
            case 1:
                return new RevenuFragment();
        }
        return new DepenseFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
