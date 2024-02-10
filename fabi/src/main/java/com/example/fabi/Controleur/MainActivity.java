package com.example.fabi.Controleur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fabi.Model.AccountTable;
import com.example.fabi.Model.Session;
import com.example.fabi.Model.UserTable;
import com.example.fabi.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mBottomNavigationView = findViewById(R.id.bottom_navigation_menu);
        mToolbarMain = findViewById(R.id.toolbar_main);
        mSession = new Session(this);
        mSQLiteDatabase = openOrCreateDatabase("ninocash.db",MODE_PRIVATE,null);
        mUserTable = new UserTable(this);
        mAccountTable = new AccountTable(this);
        mUserTable.onCreate(mSQLiteDatabase);
        mAccountTable.onCreate(mSQLiteDatabase);
        mHomeFragment = new HomeFragment();
        mHistoriqueFragment = new HistoriqueFragment();
        /* Initialisation des badge
        BadgeDrawable badgeDrawableHome = mBottomNavigationView.getOrCreateBadge(R.id.accueil);
        BadgeDrawable badgeDrawableStatistique = mBottomNavigationView.getOrCreateBadge(R.id.statistique);
        /* Desactiver les Badges par defaut
        badgeDrawableHome.setVisible(false);
        badgeDrawableStatistique.setVisible(false);*/

        /* Basculement entre les menus*/

        // Pour Actualiser
          mToolbarMain.getMenu().getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent home = new Intent(MainActivity.this, MainActivity.class);
                startActivity(home);
                finish();
                return false;
            }
        });

        // Pour La Suggestion
        mToolbarMain.getMenu().getItem(2).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent home = new Intent(MainActivity.this,SuggestionActivity.class);
                startActivity(home);
                return false;
            }
        });

        // Parametre
        mToolbarMain.getMenu().getItem(3).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent home = new Intent(MainActivity.this, ParametreActivity.class);
                startActivity(home);
                return false;
            }
        });
        mToolbarMain.getMenu().getItem(4).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                deconnecter();
                return false;
            }
        });
        /* Ouverture de la session si ca existe  si non lancement de la page login */
        try {
            Toast.makeText(this, mSession.getMatricule(), Toast.LENGTH_SHORT);
        }
        catch (Exception e) {
            Intent login = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(login);
            finish();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMain,mHomeFragment).commit();
        /* En Clikquant sur les boutton de la barre de navigation */
            mBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    switch (item.getItemId())
                    {
                        case R.id.accueil:
                            if (mHomeFragment.isAdded()) {
                                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMain,mHomeFragment).commit();
                            }
                            {
                                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMain,new HomeFragment()).commit();
                            }
                            return true;
                        case R.id.statistique:
                            if (mHistoriqueFragment.isAdded()) {
                                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMain,mHistoriqueFragment).commit();
                            }
                            else
                            {
                                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMain,new HistoriqueFragment()).commit();
                            }
                            return true;
                    }
                    return false;
                }
            });
        }
    private void deconnecter() {
        mSession.onUpgrade(mSQLiteDatabase,0,1);
        Intent login = new Intent(MainActivity.this, MainActivity.class);
        startActivity(login);
        finish();
//        exit(1);
    }
    public BottomNavigationView getBottomNavigationView() {
        return mBottomNavigationView;
    }
    private SQLiteDatabase mSQLiteDatabase;
    private UserTable mUserTable;
    private AccountTable mAccountTable;
    private Session mSession;
    private HomeFragment mHomeFragment;
    private HistoriqueFragment mHistoriqueFragment;
    private BottomNavigationView mBottomNavigationView;
    private Toolbar mToolbarMain;

}