package com.example.rubrub.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.rubrub.EntityClass.ScheduleClass;
import com.example.rubrub.R;
import com.example.rubrub.View.SearchbyplaceAdapter;
import com.example.rubrub.View.SearchbyteacherAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class SearchbyplaceActivity extends AppCompatActivity {

    private ArrayList<ScheduleClass> scheduleClassList=new ArrayList<>();
    private SearchbyplaceAdapter adapter;
    public static final String TAG = "SearchbyplaceActivity";
    private RelativeLayout noPlace;
    private ScheduleClass scheduleClass;
    private EditText editText;
    private String place;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchbyplace_xml);
        editText=findViewById(R.id.search_byplaceedit);
        button=findViewById(R.id.surefor_place);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.searchbyplace_list);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(SearchbyplaceActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new SearchbyplaceAdapter(scheduleClassList);
        recyclerView.setAdapter(adapter);
        search();
    }

    private void search(){
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                BmobQuery<ScheduleClass> query = new BmobQuery<>();
                place=editText.getText().toString();
                query.addWhereEqualTo("Cplace" ,place);
                //query.include("place");
                query.findObjects(new FindListener<ScheduleClass>() {
                    @Override
                    public void done(List<ScheduleClass> list, BmobException e) {
                        try {
                            adapter.getList().clear();
                            if(e == null){
                                adapter.getList().addAll(list);
                                for(ScheduleClass x : adapter.getList()){
                                    //x.setDish(dish);
                                }
                                Log.i(TAG, "searchbytime:查询成功" + list.size());
                                if(list.size() > 0)
                                    Log.i(TAG, "searchbytime :查询成功" +
                                            list.get(0).getCname());
                            }else {
                                Log.i(TAG, "searchbytime :查询失败" + e.getMessage());
                            }
                            notFoundAction();
                            adapter.notifyDataSetChanged();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                });
            }
        });

    }

    private void notFoundAction(){
        if(adapter.getList().size() == 0){
            noPlace.setVisibility(View.VISIBLE);
        }else {
            noPlace.setVisibility(View.INVISIBLE);
        }
    }
}
