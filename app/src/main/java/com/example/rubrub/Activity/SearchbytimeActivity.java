package com.example.rubrub.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.rubrub.EntityClass.MyClass;
import com.example.rubrub.EntityClass.ScheduleClass;
import com.example.rubrub.R;
import com.example.rubrub.View.SearchbytimeAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;

import static cn.bmob.v3.b.From.e;

public class SearchbytimeActivity extends AppCompatActivity  {
    private ArrayList<ScheduleClass>scheduleClassList=new ArrayList<>();
    private SearchbytimeAdapter adapter;
    public static final String TAG = "SearchbytimeActivity";
    private RelativeLayout noPlace;
    private ScheduleClass scheduleClass;
    //private String Cteacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchbytime_xml);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.search_bytime);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new SearchbytimeAdapter(scheduleClassList);
        recyclerView.setAdapter(adapter);
        searchCname();
    }

    private void searchCname(){
        BmobQuery<ScheduleClass> query = new BmobQuery<>();
        //query.addWhereEqualTo("dish" , new BmobPointer(dish));
        //query.include("place");
        query.findObjects(new FindListener<ScheduleClass>() {
            @Override
            public void done(List <ScheduleClass> list, BmobException e) {
                try {
                    adapter.getList().clear();
                    if(e == null){
                        adapter.getList().addAll(list);
                        for(ScheduleClass x : adapter.getList()){
                            //x.setDish(dish);
                        }
                        Log.i(TAG, "searchDishPlace :查询成功" + list.size());
                        if(list.size() > 0)
                            Log.i(TAG, "searchDishPlace :查询成功" +
                                    list.get(0).getCname());
                    }else {
                        Log.i(TAG, "searchDishPlace :查询失败" + e.getMessage());
                    }
                    notFoundAction();
                    adapter.notifyDataSetChanged();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
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
