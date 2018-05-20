package com.example.rubrub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.*;




public class MainActivity extends AppCompatActivity {

private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.search:
                        Intent intent =new Intent(MainActivity.this,SearchActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.neighbour:
                        Intent intent1 =new Intent(MainActivity.this,NeighbourActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.board:
                        Intent intent2 =new Intent(MainActivity.this,AnnouncementActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.me:
                        Intent intent3 =new Intent(MainActivity.this,MeActivity.class);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });


    }

}
