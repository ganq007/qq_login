package cn.geq.ahgf.qq_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edname;
    EditText edpass;
    Button bulogin;
    Button buregist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //取得控件
        edname = findViewById(R.id.ed_name);
        edpass = findViewById(R.id.ed_pass);
        bulogin = findViewById(R.id.bu_login);
        buregist = findViewById(R.id.bu_regist);
        bulogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=  edname.getText().toString().trim();
                String pass = edpass.getText().toString().trim();
                if(TextUtils.isEmpty(name)&&TextUtils.isEmpty(pass)){
                    Toast.makeText(MainActivity.this, "用户名密码不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    MyOpenHeper mysql=  new MyOpenHeper(MainActivity.this,"user",null,1);

                }
            }
        });

















        //注册页面
        buregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.mylayout);//加载注册页面布局

                Button edlogin2= findViewById(R.id.bu_login2);//登陆按钮
                Button edregisr2 = findViewById(R.id.bu_regist2);//注册按钮

                edregisr2.setOnClickListener(new View.OnClickListener() {//注册事件
                    @Override
                    public void onClick(View v) {
                        EditText  edname2= findViewById(R.id.ed_name2);
                        EditText  edpass2 =findViewById(R.id.ed_pass2);
                        EditText  edpass3=findViewById(R.id.ed_pass3);
                        String name2 = edname2.getText().toString().trim();
                        String pass2 = edpass2.getText().toString().trim();
                        String pass3 = edpass3.getText().toString().trim();//取值

                        if(TextUtils.isEmpty(name2)&&TextUtils.isEmpty(pass2)&&TextUtils.isEmpty(pass3)){
                            Toast.makeText(MainActivity.this, "注册不能为空", Toast.LENGTH_SHORT).show();
                        }else if(!pass2.equals(pass3)){
                            Toast.makeText(MainActivity.this, "密码不相同", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                edlogin2.setOnClickListener(new View.OnClickListener() {//登陆事件
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.activity_main);
                    }
                });
         }
        });
    }
}