package com.example.rubrub.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;

import android.widget.TextView;

import com.example.rubrub.EntityClass.BlogClass;
import com.example.rubrub.EntityClass.MyClass;
import com.example.rubrub.R;

import java.text.SimpleDateFormat;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by wx‘mac pro on 2018/6/8.
 */

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;

import android.widget.TextView;

import com.example.rubrub.EntityClass.BlogClass;
import com.example.rubrub.EntityClass.MyClass;
import com.example.rubrub.R;

import java.text.SimpleDateFormat;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by wx‘mac pro on 2018/6/8.
 */

public class Me_lookActivity extends FragmentActivity{
    private TextView textView;
    private String outputText="偏好课程为：";
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_look_xml);
        textView =(TextView)findViewById(R.id.text_view1);
        //textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        //textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        BmobQuery<MyClass> query = new BmobQuery<MyClass>();
        //查询playerName叫“比目”的数据
        query.addWhereEqualTo("searchused", 1);
        //返回50条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(50);
        //执行查询方法
        query.findObjects(new FindListener<MyClass>() {
            @Override
            public void done(List<MyClass> object, BmobException e) {
                if(e==null){
                    //toast("查询成功：共"+object.size()+"条数据。");
                    for (MyClass bc : object) {
                        //获得数据的objectId信息
                        //outputText = bc.getUid();
                        //获得playerName的信息
                        outputText += bc.getUname();
                        //获得createdAt数据创建时间（注意是：createdAt，不是createAt）
                        //获取留言
                        outputText += bc.getKCname();
                        outputText += "\r\n";
                        textView.setText(outputText);
                    }
                }else{
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });



    }


}