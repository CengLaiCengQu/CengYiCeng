package com.example.rubrub;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import android.view.*;
import android.net.Uri;

public class AnnouncementActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
 @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.announcement_xml);
        button1 = (Button) findViewById(R.id.jump1);
        button1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent = new Intent(Intent.ACTION_VIEW);
                                           intent.setData(Uri.parse("http://www.baidu.com"));
                                           startActivity(intent);
                                       }
                                   }
        );

    button2 = (Button) findViewById(R.id.jump2);
     button2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(Intent.ACTION_VIEW);
             intent.setData(Uri.parse("http://jwc.hzau.edu.cn"));
             startActivity(intent);
         }
     });
    }
}
