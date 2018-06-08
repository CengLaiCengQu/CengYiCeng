package com.example.rubrub;

import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import android.view.*;
import android.net.Uri;

public class AnnouncementActivity extends FragmentActivity {
    private Button button1;
    private Button button2;
 @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcement_xml);

    }
}
