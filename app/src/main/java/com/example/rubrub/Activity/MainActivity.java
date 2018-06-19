package com.example.rubrub.Activity;

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
import com.example.rubrub.R;

import java.util.ArrayList;
import cn.bmob.v3.Bmob;
import android.app.Activity;
import android.os.Bundle;

import cn.bmob.v3.Bmob;
import android.app.Activity;
import android.os.Bundle;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.BmobInstallationManager;
import cn.bmob.v3.BmobQuery;


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
        Bmob.initialize(this, "14b82d3140bd6401d0584482b4015795");
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
