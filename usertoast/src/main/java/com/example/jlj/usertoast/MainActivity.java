package com.example.jlj.usertoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //监听器
        class listener implements View.OnClickListener{

            EditText value = (EditText)findViewById(R.id.editText);

            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button:
                        Toast.makeText(MainActivity.this , value.getText() , Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button2:
                        Toast mToast = new Toast(MainActivity.this);
                        ImageView mimageView = new ImageView(MainActivity.this);
                        mimageView.setImageResource(R.drawable.qq);
                        mToast.setView(mimageView);
                        mToast.show();
                        break;
                    case R.id.button3:
                        Toast mToast1 = new Toast(MainActivity.this);
                        TextView textView = new TextView(MainActivity.this);
                        textView.setText("这是测试语句");
                        mToast1.setView(textView);
                        mToast1.show();
                        break;
                    default:
                        break;
                }
            }
        }
        //获取按钮并绑定监听器
        Button button1 = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);

        button1.setOnClickListener(new listener());
        button2.setOnClickListener(new listener());
        button3.setOnClickListener(new listener());




    }

}
