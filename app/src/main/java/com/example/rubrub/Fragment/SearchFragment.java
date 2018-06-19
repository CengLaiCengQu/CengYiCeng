package com.example.rubrub.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rubrub.Activity.SearchbyplaceActivity;
import com.example.rubrub.Activity.SearchbyteacherActivity;
import com.example.rubrub.Activity.SearchbytimeActivity;
import com.example.rubrub.R;

public class SearchFragment extends Fragment {
    private Button search_bytime;
    private Button search_byplace;
    private Button search_byteacher;
    private AppCompatActivity appCompatActivity;

    public AppCompatActivity getAppCompatActivity() {
        return appCompatActivity;
    }

    public void setAppCompatActivity(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.search_fragment_xml,container,false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        search_bytime = (Button) getActivity().findViewById(R.id.search_bytime);
        search_bytime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SearchbytimeActivity.class);
                getActivity().startActivity(intent);
            }
        });

        search_byplace = (Button) getActivity().findViewById(R.id.search_byplace);
        search_byplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SearchbyplaceActivity.class);
                getActivity().startActivity(intent);
            }
        });
        search_byteacher = (Button) getActivity().findViewById(R.id.search_byteacher);
        search_byteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SearchbyteacherActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }

}
