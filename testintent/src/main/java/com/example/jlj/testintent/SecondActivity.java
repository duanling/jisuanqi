package com.example.jlj.testintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bun = this.getIntent().getExtras();
        String sex = bun.getString("sex");
        double height = bun.getDouble("height");

        //取得性别
        String sextext;
        if (sex.equals("M")) {
            sextext = "男性";
        } else {
            sextext = "女性";
        }
        //取得标准体重
        String weight = getWeight(sex, height);

        //打印到TextView控件
        TextView result1 = (TextView) findViewById(R.id.result1);
        TextView result2 = (TextView) findViewById(R.id.result2);
        result1.setText("您是一位" + sextext + ",您的身高为" + height + "cm");
        result2.setText("您的标准体重为：" + weight + "kg");

        //返回按钮
        Button button = (Button) findViewById(R.id.backbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                SecondActivity.this.finish();
            }
        });

    }

    //四舍五入
    public String format(double num) {
        NumberFormat formater = new DecimalFormat("0.00");
        String s = formater.format(num);
        return s;
    }

    //计算标准体重
    public String getWeight(String sex, double height) {
        String weight;
        if (sex.equals("M")) {
            weight = format((height - 80) * 0.7);
        } else {
            weight = format((height - 70) * 0.6);
        }
        return weight;
    }


}
