package com.example.rubrub.Fragment;

import android.content.Intent;
import android.support.v4 .app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
//import com.example.rubrub.setInformation
import com.example.rubrub.Activity.Me_lookActivity;
import com.example.rubrub.Activity.Me_setActivity;
import com.example.rubrub.R;


public class MeFragment extends Fragment {


    private AppCompatActivity appCompatActivity;
    private static TextView v1;
    private static TextView v2;
    private static String name;
    private static String college;
    public AppCompatActivity getAppCompatActivity() {
        return appCompatActivity;
    }

    public void setAppCompatActivity(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.me_fragment_xml,container,false);

            return view;//这里别忘记了将上面的view返回
        }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        v1 =(TextView)getActivity().findViewById(R.id.name1);
        v2 = (TextView)getActivity().findViewById(R.id.college1);
        Button button1 = (Button)getActivity(). findViewById(R.id.item_set);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , Me_setActivity.class);
                getActivity().startActivity(intent);

            }
        });
        Button button2 = (Button)getActivity(). findViewById(R.id.item_looklike);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , Me_lookActivity.class);
                getActivity().startActivity(intent);

            }
        });
    }
    public static void setName(String n){
        name = n;
        v1.setText("昵称："+name);
    }
    public static void setCollege(String n1){
        college = n1;
        v2.setText("学院："+college);
    }


}

