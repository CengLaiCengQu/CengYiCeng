package com.example.rubrub.Activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rubrub.EntityClass.MyClass;
import com.example.rubrub.Fragment.MeFragment;
import com.example.rubrub.R;
//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.appindexing.Thing;
//import com.google.android.gms.common.api.GoogleApiClient;


import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by wx‘mac pro on 2018/6/8.
 */

public class Me_setActivity extends FragmentActivity  {

    EditText edit_name, edit_collage;
    Button btn_back, btn_true;
    TextView tv_add;
   // String old_name = "";
    //String old_collage = "";
    String name ;
    String collage ;
    protected int mScreenWidth;
    protected int mScreenHeight;

    //public static final String TAG = "bmob";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        // 初始化 Bmob SDK
        // 使用时请将第二个参数Application ID替换成你在Bmob服务器端创建的Application ID
      //  Bmob.initialize(this, "14b82d3140bd6401d0584482b4015795");

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //获取当前屏幕宽高
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        mScreenWidth = metric.widthPixels;
        mScreenHeight = metric.heightPixels;
        setContentView();
        initViews();
        initListeners();
      //  initData();
    }
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
   // private GoogleApiClient client;

    //private EditText editText;
    //private Button button;
    // @Override
    public void setContentView() {
        // TODO Auto-generated method stub
        setContentView(R.layout.me_set_xml);
    }
    public void initViews() {
        // TODO Auto-generated method stub
        //tv_add = (TextView) findViewById(R.id.tv_add);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_true = (Button) findViewById(R.id.btn_true);
        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_collage = (EditText) findViewById(R.id.edit_collage);

    }

    public void initListeners() {
        // TODO Auto-generated method stub
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MeFragment.setName(name);
                MeFragment.setCollege(collage);
                finish();

            }
        });
        btn_true.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addByType();
            }
        });
    }

    // @Override
   // public void initData() {
        // TODO Auto-generated method stub

        //old_name = getIntent().getStringExtra("name");
       // old_collage = getIntent().getStringExtra("collage");
      //  edit_name.setText(old_name);
        //edit_collage.setText(old_collage);
        // if (from.equals("Lost")) {
        //  tv_add.setText("添加失物信息");
        // } else {
        // tv_add.setText("添加招领信息");
        //  }
   // }

    //@Override
    /*public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v == btn_true) {
            addByType();

        } else if (v == btn_back) {
            finish();
        }
    }*/


    private void addByType() {
       // String name1 = edit_name.getText().toString();
       // String collage1 = edit_collage.getText().toString();
        if (edit_name.length()==0) {
            Toast toast=Toast.makeText(getApplicationContext(), "请填写昵称", Toast.LENGTH_SHORT);
            toast.show();
          //  ShowToast("请填写昵称");
            return;
        }
        else{
            name = edit_name.getText().toString();
        }


        if (edit_collage.length()==0) {
            Toast toast=Toast.makeText(getApplicationContext(), "请填写院系", Toast.LENGTH_SHORT);
            toast.show();
           // ShowToast("请填写院系");
            return;
        }
        else {
            collage = edit_collage.getText().toString();

        }

      // addmyclass();
        MyClass myClass = new MyClass();
        myClass.setUname(name);
        myClass.setCollege(collage);
        myClass.save(new SaveListener<String>(){

            @Override
            public void done(String objectId, BmobException e) {
                if(e==null){
                    // ShowToast("成功导入");
                    Toast toast=Toast.makeText(getApplicationContext(), "成功导入", Toast.LENGTH_SHORT);
//显示toa
                    toast.show();

                }else{
                    // ShowToast("失败");
                    Toast toast = Toast.makeText(getApplicationContext(), "数据添加失败！", Toast.LENGTH_SHORT);
                    toast.show();
                    //Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
        return ;




    }

  /*  private void addmyclass() {
        MyClass myClass = new MyClass();
        myClass.setUname(name);
        myClass.setCollege(collage);
        myClass.save(new SaveListener<String>(){

            @Override
            public void done(String objectId, BmobException e) {
                if(e==null){
                   // ShowToast("成功导入");
                    Toast toast=Toast.makeText(getApplicationContext(), "成功导入", Toast.LENGTH_SHORT);
//显示toa
                    toast.show();

                }else{
                   // ShowToast("失败");
                    Toast.makeText(getApplicationContext(), "数据添加失败！", Toast.LENGTH_SHORT).show();
                    //Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
        //return;
    }*/


  /*  Toast mToast;

    public void ShowToast(String text) {
        if (!TextUtils.isEmpty(text)) {
            if (mToast == null) {
                mToast = Toast.makeText(getApplicationContext(), text,
                        mToast.LENGTH_SHORT);
            } else {
                mToast.setText(text);
            }
            mToast.show();
        }
    }*/

           /* protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.me_set_xml);
                Button button1 = (Button) findViewById(R.id.btn_true);
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Me_setActivity.this, "已经成功保存", Toast.LENGTH_SHORT).show();
                    }

                });*/
    //editText=(EditText)findViewById(R.id.editText);
    //button.setOnClickListener(this);


    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.
    // client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    /** 获取当前状态栏的高度
     * getStateBar
     * @Title: getStateBar
     * @throws
     */
   /* public  int getStateBar(){
        Rect frame = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        return statusBarHeight;
    }

    public static int dip2px(Context context,float dipValue){
        float scale=context.getResources().getDisplayMetrics().density;
        return (int) (scale*dipValue+0.5f);
    }*/
}

/**
 * ATTENTION: This was auto-generated to implement the App Indexing API.
 * See https://g.co/AppIndexing/AndroidStudio for more information.
 */

//   }
    /**///public Action getIndexApiAction() {//
//Thing object = new Thing.Builder()
//.setName("Me_set Page") // TODO: Define a title for the content shown.
// TODO: Make sure this auto-generated URL is correct.
//.setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
//  .build();
//return new Action.Builder(Action.TYPE_VIEW)
//.setObject(object)
// .setActionStatus(Action.STATUS_TYPE_COMPLETED)
//  .build();
// }

   /* @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

  //  @Override
    /*public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
    //MyClass =new MyClass();
    //myclass.setUname("uuu");


}
    //@Override
   // public void onClick(View v){

        //switch (v.getId()){

           // case R.id.store_button:
               // String inputText=editText.getText().toString();
                //Toast.makeText(Me_setActivity.this,inputText,Toast.LENGTH_SHORT).show();
                //break;
           // default:
              //  break;*/




