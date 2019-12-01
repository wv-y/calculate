package com.example.calculate;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoneyActivity extends AppCompatActivity {

    private List<String> moneyList = new ArrayList<String>();
    private Spinner moneySp1, moneySp2;
    private ArrayAdapter<String> money_adapter;
    Money money = new Money();
    private String money1, money2;
    private double moneyNum; //用来存储计算结果
    private double rate; //用来存储汇率

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);

        Button buttonBack = (Button) findViewById(R.id.ba);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        final TextView moneyText1 = (TextView) findViewById(R.id.money_text1);
        final TextView moneyText2 = (TextView) findViewById(R.id.money_text2);

        moneyList.add("CNY");
        moneyList.add("USD");
        moneySp1 = (Spinner) findViewById(R.id.money_spinner1);
        moneySp2 = (Spinner) findViewById(R.id.money_spinner2);

        money_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, moneyList);
        money_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        moneySp1.setAdapter(money_adapter);
        moneySp1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                money1 = money_adapter.getItem(arg2); //获取下拉列表选择的内容
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        moneySp2.setAdapter(money_adapter);
        moneySp2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                money2 = money_adapter.getItem(arg2); //获取下拉列表选择的内容

            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        Button buttonQue = (Button) findViewById(R.id.que);
        buttonQue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Handler handler = new Handler() {
                    @Override
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);

                        if (msg.what == 1) {
                            String str = (String) msg.getData().get("rate");
                            moneyNum = Double.parseDouble(str);
                            Log.i("moneyNum", String.valueOf(moneyNum));
                            moneyText2.setText(moneyNum + "");
                        }

                    }
                };
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            rate = money.moneyCon(money1, money2);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        double number = Double.parseDouble(moneyText1.getText().toString()) * rate;
                        Message ms = new Message();
                        ms.what = 1;
                        Bundle bundle = new Bundle();
                        bundle.putString("rate", String.valueOf(number));
                        ms.setData(bundle);
                        handler.sendMessage(ms);
                    }
                }).start();
            }
        });
    }

}
