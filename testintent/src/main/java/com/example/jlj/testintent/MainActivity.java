package com.example.jlj.testintent;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //监听器内部类
        class listener implements View.OnClickListener {
            String Sex;
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.height);
                //处理身高输入为空
                if(editText.getText().toString().length() == 0){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("温馨提示");
                    dialog.setMessage("请输入您的身高");
                    dialog.setNeutralButton("确定", new DialogInterface.OnClickListener() {
                        EditText editText = (EditText) findViewById(R.id.height);
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            editText.setHighlightColor(Color.RED);
                            editText.setHint("未输入字符");
                        }
                    }).create().show();
                    return;
                }

                RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
                Double height = Double.parseDouble(editText.getText().toString());
                if (radiogroup.getCheckedRadioButtonId() == R.id.male) {
                    Sex = "M";
                } else {
                    Sex = "F";
                }
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SecondActivity.class);
                Bundle bun = new Bundle();
                bun.putString("sex", Sex);
                bun.putDouble("height", height);
                intent.putExtras(bun);
                startActivity(intent);
                MainActivity.this.finish();
            }
        }

        //获得按钮并绑定监听器
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new listener());
    }

}
