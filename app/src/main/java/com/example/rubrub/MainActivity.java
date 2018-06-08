package com.example.rubrub;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.example.rubrub.Fragment.AnnouncementFragment;
import com.example.rubrub.Fragment.MeFragment;
import com.example.rubrub.Fragment.NeighbourFragment;
import com.example.rubrub.Fragment.SearchFragment;

import java.util.ArrayList;


public class MainActivity extends FragmentActivity {

private BottomNavigationView bottomNavigationView;
    private AnnouncementFragment announcementFragment;
    private SearchFragment searchFragment;
    private NeighbourFragment neighbourFragment;
    private MeFragment meFragment;

    public void replace(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.search,fragment);
        transaction.commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.search:
                        replace(new SearchFragment());
                        //transaction.replace(R.id.search,searchFragment);
                        //transaction.commit();
                        //Intent intent =new Intent(MainActivity.this,SearchActivity.class);
                        //startActivity(intent);
                        //fragment = new SearchFragment();
                        //transaction.add(R.id.search,fragment);
                        //transaction.replace(R.id.search,fragment);
                        break;
                    case R.id.neighbour:
                          replace(new NeighbourFragment());
                        break;
                    case R.id.board:
                        replace(new AnnouncementFragment());
                        break;
                    case R.id.me:
                        replace(new MeFragment());

                        break;
                }
                return true;
            }
        });

    }


}
