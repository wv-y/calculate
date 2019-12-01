package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ConversionActivity extends AppCompatActivity {

    private List<String> lengthList = new ArrayList<String>();
    private List<String> areaList = new ArrayList<String>();
    private List<String> numList = new ArrayList<String>();
    private Spinner lengthSp1, lengthSp2, areaSp1, areaSp2, numSq1, numSq2;
    private ArrayAdapter<String> lenght_adapter;
    private ArrayAdapter<String> area_adapter;
    private ArrayAdapter<String> num_adapter;
    private String lenght1, lenght2, area1, area2, num1, num2;
    private Conversion con = new Conversion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        Button buttonBack = (Button) findViewById(R.id.B);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //获取文本框
        final TextView lenghtText1 = (TextView) findViewById(R.id.lenght_text1);
        final TextView lenghtText2 = (TextView) findViewById(R.id.lenght_text2);
        final TextView areaText1 = (TextView) findViewById(R.id.area_text1);
        final TextView areaText2 = (TextView) findViewById(R.id.area_text2);
        final TextView numText1 = (TextView) findViewById(R.id.num_text1);
        final TextView numText2 = (TextView) findViewById(R.id.num_text2);
        //第一步：添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项
        lengthList.add("mm");
        lengthList.add("cm");
        lengthList.add("dm");
        lengthList.add("m");
        lengthList.add("km");

        areaList.add("mm2");
        areaList.add("cm2");
        areaList.add("dm2");
        areaList.add("m2");
        areaList.add("km2");

        numList.add("2");
        numList.add("8");
        numList.add("10");
        numList.add("16");

        lengthSp1 = (Spinner) findViewById(R.id.lenght_spinner1);
        lengthSp2 = (Spinner) findViewById(R.id.lenght_spinner2);
        areaSp1 = (Spinner) findViewById(R.id.area_spinner1);
        areaSp2 = (Spinner) findViewById(R.id.area_spinner2);
        numSq1 = (Spinner) findViewById(R.id.num_spinner1);
        numSq2 = (Spinner) findViewById(R.id.num_spinner2);

        //第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。
        lenght_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lengthList);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        lenght_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        lengthSp1.setAdapter(lenght_adapter);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        lengthSp1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                /* 将所选mySpinner 的值带入myTextView 中*/
                //myTextView.setText("您选择的是：" + adapter.getItem(arg2));    /* 将mySpinner 显示*/
                // arg0.setVisibility(View.VISIBLE);
                lenght1 = lenght_adapter.getItem(arg2); //获取下拉列表选择的内容

            }

            public void onNothingSelected(AdapterView<?> arg0) {
               /* myTextView.setText("NONE");
                arg0.setVisibility(View.VISIBLE);*/
            }
        });


        //为长度2的下拉列表定义适配器
        lengthSp2.setAdapter(lenght_adapter);
        lengthSp2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                lenght2 = lenght_adapter.getItem(arg2);
                try {
                    switch (lenght1) {
                        case "mm":
                            if (lenght2.equals("mm"))
                                lenghtText2.setText(lenghtText1.getText());
                            if (lenght2.equals("cm")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.mmTocm(dou));
                            }
                            if (lenght2.equals("m")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.mmTom(dou));
                            }
                            if (lenght2.equals("dm")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.mmTodm(dou));
                            }
                            if (lenght2.equals("km")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.mmTokm(dou));
                            }
                            break;
                        case "cm":
                            if (lenght2.equals("cm"))
                                lenghtText2.setText(lenghtText1.getText());
                            if (lenght2.equals("mm")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.cmTomm(dou));
                            }
                            if (lenght2.equals("dm")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.cmTodm(dou));
                            }
                            if (lenght2.equals("m")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.cmTom(dou));
                            }
                            if (lenght2.equals("km")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.cmTokm(dou));
                            }
                            break;
                        case "dm":
                            if (lenght2.equals("mm")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.dmTomm(dou));
                            }
                            if (lenght2.equals("cm")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.dmTocm(dou));
                            }
                            if (lenght2.equals("dm")) {
                                lenghtText2.setText(lenghtText1.getText());
                            }
                            if (lenght2.equals("m")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.dmTom(dou));
                            }
                            if (lenght2.equals("km")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.dmTokm(dou));
                            }
                            break;
                        case "m":
                            if (lenght2.equals("mm")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.mTomm(dou));
                            }
                            if (lenght2.equals("cm")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.mTocm(dou));
                            }
                            if (lenght2.equals("dm")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.mTodm(dou));
                            }
                            if (lenght2.equals("m")) {
                                lenghtText2.setText(lenghtText1.getText());
                            }
                            if (lenght2.equals("km")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.mTokm(dou));
                            }
                            break;
                        case "km":
                            if (lenght2.equals("mm")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.kmTomm(dou));
                            }
                            if (lenght2.equals("cm")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.kmTocm(dou));
                            }
                            if (lenght2.equals("dm")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.kmTodm(dou));
                            }
                            if (lenght2.equals("m")) {
                                double dou = Double.parseDouble(lenghtText1.getText().toString());
                                lenghtText2.setText(con.kmTom(dou));
                            }
                            if (lenght2.equals("km")) {

                                lenghtText2.setText(lenghtText1.getText());
                            }
                            break;
                        default:
                    }
                }
                catch (Exception e){
                    Toast toast = Toast.makeText(ConversionActivity.this,"输入错误",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        /****  面积单位转换*/
        area_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, areaList);
        area_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaSp1.setAdapter(area_adapter);
        areaSp1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                area1 = area_adapter.getItem(arg2); //获取下拉列表选择的内容

            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        areaSp2.setAdapter(area_adapter);
        areaSp2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                area2 = area_adapter.getItem(arg2); //获取下拉列表选择的内容
                try {
                    switch (area1) {
                        case "mm2":
                            if (area2.equals("mm2")) {
                                areaText2.setText(areaText1.getText());
                            }
                            if (area2.equals("cm2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.mm2Tocm2(dou));
                            }
                            if (area2.equals("dm2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.mm2Todm2(dou));
                            }
                            if (area2.equals("m2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.mm2Tom2(dou));
                            }
                            if (area2.equals("km2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.mm2Tokm2(dou));
                            }
                            break;
                        case "cm2":
                            if (area2.equals("mm2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.cm2Tomm2(dou));
                            }
                            if (area2.equals("cm2")) {

                                areaText2.setText(areaText1.getText());
                            }
                            if (area2.equals("dm2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.cm2Todm2(dou));
                            }
                            if (area2.equals("m2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.cm2Tom2(dou));
                            }
                            if (area2.equals("km2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.cm2Tokm2(dou));
                            }
                            break;
                        case "dm2":
                            if (area2.equals("mm2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.dm2Tomm2(dou));
                            }
                            if (area2.equals("cm2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.dm2Tocm2(dou));
                            }
                            if (area2.equals("dm2")) {

                                areaText2.setText(areaText1.getText());
                            }
                            if (area2.equals("m2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.dm2Tom2(dou));
                            }
                            if (area2.equals("km2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.dm2Tokm2(dou));
                            }
                            break;
                        case "m2":
                            if (area2.equals("mm2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.m2Tomm2(dou));
                            }
                            if (area2.equals("cm2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.m2Tocm2(dou));
                            }
                            if (area2.equals("dm2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.m2Todm2(dou));
                            }
                            if (area2.equals("m2")) {

                                areaText2.setText(areaText1.getText());
                            }
                            if (area2.equals("km2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.m2Tokm2(dou));
                            }
                            break;
                        case "km2":
                            if (area2.equals("mm2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.km2Tomm2(dou));
                            }
                            if (area2.equals("cm2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.km2Tocm2(dou));
                            }
                            if (area2.equals("dm2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.km2Todm2(dou));
                            }
                            if (area2.equals("m2")) {
                                double dou = Double.parseDouble(areaText1.getText().toString());
                                areaText2.setText(con.km2Tom2(dou));
                            }
                            if (area2.equals("km2")) {
                                areaText2.setText(areaText1.getText());
                            }
                            break;
                        default:
                    }
                }
                catch (Exception e){
                    Toast toast = Toast.makeText(ConversionActivity.this,"输入错误",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        /****  进制转换*/
        num_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, numList);
        num_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numSq1.setAdapter(num_adapter);
        numSq1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                num1 = num_adapter.getItem(arg2); //获取下拉列表选择的内容

            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        numSq2.setAdapter(num_adapter);
        numSq2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                num2 = num_adapter.getItem(arg2); //获取下拉列表选择的内容
                try {
                    switch (num1) {
                        case "2":
                            if (num2.equals("2")) {
                                numText2.setText(numText1.getText());
                            }
                            if (num2.equals("8")) {
                                numText2.setText(con.twoToEight(numText1.getText().toString()));
                            }
                            if (num2.equals("10")) {
                                numText2.setText(con.twoToTen(numText1.getText().toString()));
                            }
                            if (num2.equals("16")) {
                                numText2.setText(con.twoToSixteen(numText1.getText().toString()));
                            }
                            break;
                        case "8":
                            if (num2.equals("2"))
                                numText2.setText(con.eightToTwo(numText1.getText().toString()));
                            if (num2.equals("8"))
                                numText2.setText(numText1.getText());
                            if (num2.equals("10"))
                                numText2.setText(con.eightToTen(numText1.getText().toString()));
                            if (num2.equals("16"))
                                numText2.setText(con.eightToSixteen(numText1.getText().toString()));
                            break;
                        case "10":
                            if (num2.equals("2"))
                                numText2.setText(con.TenToTwo(numText1.getText().toString()));
                            if (num2.equals("8"))
                                numText2.setText(con.TenToEight(numText1.getText().toString()));
                            if (num2.equals("10"))
                                numText2.setText(numText1.getText());
                            if (num2.equals("16"))
                                numText2.setText(con.TenToSixteen(numText1.getText().toString()));
                            break;
                        case "16":
                            if (num2.equals("2"))
                                numText2.setText(con.SixteenToTwo(numText1.getText().toString()));
                            if (num2.equals("8"))
                                numText2.setText(con.SixteenToEight(numText1.getText().toString()));
                            if (num2.equals("10"))
                                numText2.setText(con.SixteenToTen(numText1.getText().toString()));
                            if (num2.equals("2"))
                                numText2.setText(numText1.getText());
                            break;
                        default:
                    }
                }
                catch (Exception e){
                    Toast toast = Toast.makeText(ConversionActivity.this,"输入错误",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }
}
