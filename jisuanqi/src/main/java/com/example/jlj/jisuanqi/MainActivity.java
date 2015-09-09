package com.example.jlj.jisuanqi;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //监听器，根据checkbox是否选中计算结果
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {

            EditText shu1 = (EditText)findViewById(R.id.editText);
            EditText shu2 = (EditText)findViewById(R.id.editText2);

            TextView shu_1 = (TextView)findViewById(R.id.textView3);
            TextView shu_2 = (TextView)findViewById(R.id.textView5);
            TextView result = (TextView)findViewById(R.id.textView7);
            TextView fuhao = (TextView)findViewById(R.id.textView4);

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                float temp;
                String temp1;
                //计算
                switch (buttonView.getId()){
                    case R.id.checkBox:
                        temp = Float.parseFloat(shu1.getText().toString()) + Float.parseFloat(shu2.getText().toString());
                        temp1 = Float.toString(temp);
                        result.setText(temp1);
                        shu_1.setText(shu1.getText().toString());
                        shu_2.setText(shu2.getText().toString());
                        fuhao.setText("+");
                    case R.id.checkBox2:
                        temp = Float.parseFloat(shu1.getText().toString()) - Float.parseFloat(shu2.getText().toString());
                        temp1 = Float.toString(temp);
                        result.setText(temp1);
                        shu_1.setText(shu1.getText().toString());
                        shu_2.setText(shu2.getText().toString());
                        fuhao.setText("-");
                    case R.id.checkBox3:
                        temp = Float.parseFloat(shu1.getText().toString()) * Float.parseFloat(shu2.getText().toString());
                        temp1 = Float.toString(temp);
                        result.setText(temp1);
                        shu_1.setText(shu1.getText().toString());
                        shu_2.setText(shu2.getText().toString());
                        fuhao.setText("*");
                    case R.id.checkBox4:
                        temp = Float.parseFloat(shu1.getText().toString()) / Float.parseFloat(shu2.getText().toString());
                        temp1 = Float.toString(temp);
                        result.setText(temp1);
                        shu_1.setText(shu1.getText().toString());
                        shu_2.setText(shu2.getText().toString());
                        fuhao.setText("/");
                }
            }
        };
        //取出各控件

        CheckBox jia = (CheckBox)findViewById(R.id.checkBox);
        CheckBox jian = (CheckBox)findViewById(R.id.checkBox2);
        CheckBox cheng = (CheckBox)findViewById(R.id.checkBox3);
        CheckBox chu = (CheckBox)findViewById(R.id.checkBox4);

        //绑定监听器
        jia.setOnCheckedChangeListener(listener);
        jian.setOnCheckedChangeListener(listener);
        cheng.setOnCheckedChangeListener(listener);
        chu.setOnCheckedChangeListener(listener);


        //重新输入数字，清除复选框
        View.OnKeyListener list = new View.OnKeyListener() {
            CheckBox jia = (CheckBox)findViewById(R.id.checkBox);
            CheckBox jian = (CheckBox)findViewById(R.id.checkBox2);
            CheckBox cheng = (CheckBox)findViewById(R.id.checkBox3);
            CheckBox chu = (CheckBox)findViewById(R.id.checkBox4);
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(jia.isChecked()){
                    jia.setChecked(false);
                }
                if(jian.isChecked()){
                    jian.setChecked(false);
                }
                if(cheng.isChecked()){
                    cheng.setChecked(false);
                }
                if(chu.isChecked()){
                    chu.setChecked(false);
                }
                return false;
            }
        };



        //绑定输入框
        EditText shu1 = (EditText)findViewById(R.id.editText);
        EditText shu2 = (EditText)findViewById(R.id.editText2);
        shu1.setOnKeyListener(list);
        shu2.setOnKeyListener(list);

    }

}
