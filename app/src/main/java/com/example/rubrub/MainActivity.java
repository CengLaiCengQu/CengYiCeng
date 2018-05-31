package com.example.rubrub;
import android.content.Intent;
import android.support.v4.app.Fragment;
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
import cn.bmob.v3.Bmob;
import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

private BottomNavigationView bottomNavigationView;


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
                ArrayList<Fragment> list = new ArrayList<>();
                SearchFragment searchFragment =new SearchFragment();
                AnnouncementFragment announcementFragment=new AnnouncementFragment();
                NeighbourFragment neighbourFragment=new NeighbourFragment();
                MeFragment meFragment =new MeFragment();
                list.add(searchFragment);
                list.add(announcementFragment);
                list.add(neighbourFragment);
                list.add(meFragment);
                switch (item.getItemId()) {
                    case R.id.search:
                        fragment = new SearchFragment();
                        transaction.replace(R.id.search,fragment);
                        transaction.commit();
                        //Intent intent =new Intent(MainActivity.this,SearchActivity.class);
                        //startActivity(intent);
                        break;
                    case R.id.neighbour:
                        //fragment = new NeighbourFragment();
                        //transaction.replace(R.id.neighbour,fragment);
                        //transaction.commit();
                        //Intent intent1 =new Intent(MainActivity.this,NeighbourActivity.class);
                        //startActivity(intent1);
                        break;
                    case R.id.board:
                        //fragment =new AnnouncementFragment();
                        //transaction.replace(R.id.board,fragment);
                        //transaction.commit();
                        //Intent intent2 =new Intent(MainActivity.this,AnnouncementActivity.class);
                        //startActivity(intent2);
                        break;
                    case R.id.me:
                        //fragment = new MeFragment();
                        //transaction.replace(R.id.me,fragment);
                        //transaction.commit();
                        //Intent intent3 =new Intent(MainActivity.this,MeActivity.class);
                        //startActivity(intent3);
                        break;
                }
                return true;
            }
        });

    }

}
