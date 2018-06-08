package com.example.rubrub.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.support.v4 .app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rubrub.Me_lookActivity;
import com.example.rubrub.Me_setActivity;
import com.example.rubrub.R;

public class MeFragment extends Fragment {
    private Button button1;
    private Button button2;

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
        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button1 = (Button) getActivity().findViewById(R.id.item_set);

        button2 = (Button) getActivity().findViewById(R.id.item_look);
    }
    public void Set(View v){
        Intent intent1 = new Intent(this.getContext(), Me_setActivity.class);
        startActivity(intent1);
    }
    public void Look(View v){
        Intent intent2 = new Intent(this.getContext(),Me_lookActivity.class);
        startActivity(intent2);
    }

}
