package com.example.rubrub.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.rubrub.Activity.NeighbourActivity;
import com.example.rubrub.R;

public class NeighbourFragment  extends Fragment{
    private View view;
    private EditText edittext;
    private RadioGroup rg;
    private Button button;
    private String str;//标示选择了哪一种类型的发言
    String inputText;//存放用户输入的发言内容
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
//        }) ;
        rg.setOnClickListener(new RadioGroup.OnClickListener(){
            @Override
            public void onClick(View v){
                int id = rg.getCheckedRadioButtonId() ;
                switch(id) {
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
                        inputText = edittext.getText().toString();
                        inputText += str;
                }
            }
        });
    }
}


