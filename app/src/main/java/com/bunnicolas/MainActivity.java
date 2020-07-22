package com.bunnicolas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottom_nav);

        showFragement(new FragmentHome());

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.tab_home:
                        showFragement(new FragmentHome());
                        break;
                    case R.id.tab_categories:
                        showFragement(new FragmentCategories());
                        break;
                    case R.id.tab_search:
                        showFragement(new FragmentSearch());
                        break;
                    case R.id.tab_account:
                        showFragement(new FragmentAccount());
                        break;
                }
                return false;
            }

        });
    };

    public void showFragement(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layout_fragment, fragment);
        transaction.commit();
    }
}
