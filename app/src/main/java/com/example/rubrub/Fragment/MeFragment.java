package com.example.rubrub.Fragment;

import android.content.Intent;
import android.support.v4 .app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rubrub.MeActivity;
import com.example.rubrub.R;
import com.example.rubrub.SetinformationActivity;

public class MeFragment extends Fragment {

    private AppCompatActivity appCompatActivity;

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

        Button button1 = (Button)getActivity(). findViewById(R.id.item_set);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , SetinformationActivity.class);
                getActivity().startActivity(intent);

            }
        });
    }




}

