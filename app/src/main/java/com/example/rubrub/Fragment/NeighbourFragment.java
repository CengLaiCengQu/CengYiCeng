package com.example.rubrub.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.rubrub.Activity.NeighbourActivity;
import com.example.rubrub.EntityClass.BlogClass;
import com.example.rubrub.R;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class NeighbourFragment  extends Fragment{
    private View view;
    private EditText edittext;
    private RadioGroup rg;
    private Button button;
    private TextView textView;
    String str;//标示选择了哪一种类型的发言。
    String inputText;//存放用户输入的发言内容
    String outputText;//存放将要显示的内容
    String time;
    private AppCompatActivity appCompatActivity;

    public AppCompatActivity getAppCompatActivity() {
        return appCompatActivity;
    }

    public void setAppCompatActivity(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.neighbour_fragment_xml,container,false);
        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView =(TextView) getActivity().findViewById(R.id.text_view);
        BmobQuery<BlogClass> query = new BmobQuery<BlogClass>();
        //查询playerName叫“比目”的数据
        query.addWhereEqualTo("searchused", 1);
        //返回50条数据，如果不加上这条语句，默认返回10条数据
        query.setLimit(50);
        //执行查询方法
        query.findObjects(new FindListener<BlogClass>() {
            @Override
            public void done(List<BlogClass> object, BmobException e) {
                if(e==null){
                    //toast("查询成功：共"+object.size()+"条数据。");
                    for (BlogClass bc : object) {
                        //获得数据的objectId信息
                        //outputText = bc.getUid();
                        //获得playerName的信息
                        outputText += bc.getUname();
                        //获得createdAt数据创建时间（注意是：createdAt，不是createAt）
                        outputText += bc.getTime();
                        //获取留言
                        outputText += bc.getMicroBlog();
                        outputText += "\r\n";
                        textView.setText(outputText);
                    }
                }else{
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
        button = (Button)getActivity().findViewById(R.id.button);
        edittext = (EditText)getActivity().findViewById(R.id.edittext);
        rg = (RadioGroup)getActivity().findViewById(R.id.rg);
//        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                //希望弹出来选中项的文本
//                RadioButton rb = (RadioButton)findViewById(checkedId) ;
//                Toast.makeText(getActivity(), rb.getText(), Toast.LENGTH_SHORT).show() ;
//            }
//        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                //int id = rg.getCheckedRadioButtonId() ;
                switch(checkedId) {
                    case R.id.tjkc:
                        String str1 = "您选择了推荐蹭课";
                        str = "[推荐蹭课]";
                        Toast.makeText(getActivity(), str1, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.pjck:
                        String str2 = "您选择了评价蹭课";
                        str = "[评价蹭课]";
                        Toast.makeText(getActivity(), str2, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ptfy:
                        String str3 = "您选择了普通发言";
                        str = "[普通发言]";
                        Toast.makeText(getActivity(), str3, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.button:
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                        Date curDate = new Date(System.currentTimeMillis());
                        time = formatter.format(curDate);
                        //inputText += time;
                        inputText = str;
                        inputText += edittext.getText().toString();
                        BlogClass message = new BlogClass();
                        message.setUname("[蹭一蹭用户]");
                        message.setUid("001");
                        message.setMicroBlog(inputText);
                        message.setTime(curDate);
                        message.setSearchused(1);
                        message.save(new SaveListener<String>() {
                            @Override
                            public void done(String objectId,BmobException e) {
                                if(e==null){
                                    //toast("添加数据成功，返回objectId为："+objectId);
                                }else{
                                    //toast("创建数据失败：" + e.getMessage());
                                }
                            }
                        });
                }
            }
        });
    }
}


