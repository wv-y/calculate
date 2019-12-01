package com.example.calculate;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    private String ex = "";//用来保存表达式
    private EditText textEx;//获取输入的表达式
    //按钮+ - * / 等
    private Button buttonAdd;
    private Button buttonSub;
    private Button buttonMul;
    private Button buttonDiv;
    private Button buttonLeft;
    private Button buttonRight;
    private Button buttonPoint;
    private Button buttonNum0;
    private Button buttonNum1;
    private Button buttonNum2;
    private Button buttonNum3;
    private Button buttonNum4;
    private Button buttonNum5;
    private Button buttonNum6;
    private Button buttonNum7;
    private Button buttonNum8;
    private Button buttonNum9;
    private Button buttonAc;
    private Button buttonBack;
    private Button buttonEqu;
    private Button buttonSin;
    private Button buttonCos;
    private Button buttonTan;
    private Button buttonPi;
    private Button buttonE;
    private Button buttonPower;
    private Button buttonLn;
    private Button buttonRad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textEx = (EditText) findViewById(R.id.textEx);
        buttonAdd = (Button) findViewById(R.id.add);
        buttonSub = (Button) findViewById(R.id.sub);
        buttonMul = (Button) findViewById(R.id.mul);
        buttonDiv = (Button) findViewById(R.id.div);
        buttonLeft = (Button) findViewById(R.id.leftBracket);
        buttonRight = (Button) findViewById(R.id.rightBracket);
        buttonPoint = (Button) findViewById(R.id.point);
        buttonNum0 = (Button) findViewById(R.id.num0);
        buttonNum1 = (Button) findViewById(R.id.num1);
        buttonNum2 = (Button) findViewById(R.id.num2);
        buttonNum3 = (Button) findViewById(R.id.num3);
        buttonNum4 = (Button) findViewById(R.id.num4);
        buttonNum5 = (Button) findViewById(R.id.num5);
        buttonNum6 = (Button) findViewById(R.id.num6);
        buttonNum7 = (Button) findViewById(R.id.num7);
        buttonNum8 = (Button) findViewById(R.id.num8);
        buttonNum9 = (Button) findViewById(R.id.num9);
        buttonAc = (Button) findViewById(R.id.ac);
        buttonBack = (Button) findViewById(R.id.back);
        buttonEqu = (Button) findViewById(R.id.equ);
        buttonSin = (Button) findViewById(R.id.sin);
        buttonCos = (Button) findViewById(R.id.cos);
        buttonTan = (Button) findViewById(R.id.tan);
        buttonPi = (Button) findViewById(R.id.pi);
        buttonE = (Button) findViewById(R.id.e);
        buttonPower = (Button) findViewById(R.id.power);
        buttonLn = (Button) findViewById(R.id.ln);
        buttonRad = (Button) findViewById(R.id.rad);

        Configuration mConfiguration = this.getResources().getConfiguration(); //获取设置的配置信息
        int ori = mConfiguration.orientation; //获取屏幕方向
        if (ori == mConfiguration.ORIENTATION_LANDSCAPE) {
            //横屏
            // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//强制为竖屏
            buttonSin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ex = ex + "sin(";
                    textEx.setText(ex);
                }
            });

            buttonCos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ex = ex + "cos(";
                    textEx.setText(ex);
                }
            });

            buttonTan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ex = ex + "tan(";
                    textEx.setText(ex);
                }
            });

            buttonPi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ex = ex + "π";
                    textEx.setText(ex);
                }
            });

            buttonE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ex = ex + "e";
                    textEx.setText(ex);
                }
            });

            buttonPower.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ex = ex + "^";
                    textEx.setText(ex);
                }
            });

            buttonRad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ex = ex + "√(";
                    textEx.setText(ex);
                }
            });

            buttonLn.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ex = ex + "ln(";
                    textEx.setText(ex);
                }
            }));
        } /*else if (ori == mConfiguration.ORIENTATION_PORTRAIT) {
            //竖屏
            //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏




        }*/

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + "+";
                textEx.setText(ex);
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + "-";
                textEx.setText(ex);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + "*";
                textEx.setText(ex);
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + "/";
                textEx.setText(ex);
            }
        });

        buttonNum0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + "0";
                textEx.setText(ex);
            }
        });

        buttonNum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + "1";
                textEx.setText(ex);
            }
        });

        buttonNum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + "2";
                textEx.setText(ex);
            }
        });

        buttonNum3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + "3";
                textEx.setText(ex);
            }
        });

        buttonNum4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + "4";
                textEx.setText(ex);
            }
        });

        buttonNum5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + "5";
                textEx.setText(ex);
            }
        });

        buttonNum6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + "6";
                textEx.setText(ex);
            }
        });

        buttonNum7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + "7";
                textEx.setText(ex);
            }
        });

        buttonNum8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + "8";
                textEx.setText(ex);
            }
        });

        buttonNum9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + "9";
                textEx.setText(ex);
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + ".";
                textEx.setText(ex);

            }
        });

        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + "(";
                textEx.setText(ex);
            }
        });

        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = ex + ")";
                textEx.setText(ex);
            }
        });

        buttonAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ex = "";
                textEx.setText(ex);
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ex.length() != 0) {
                    ex = ex.substring(0, ex.length() - 1);
                    textEx.setText(ex);
                } else
                    textEx.setText("");
            }
        });

        buttonEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseCalculator Base = new BaseCalculator();
                scienceCal sciCal = new scienceCal();
                int a = 0;
                int b = 0;

                //判断左右括号是否配对
                char[] charEx = ex.toCharArray();
                for (int i = 0; i < charEx.length; i++) {
                    if (charEx[i] == '(')
                        a++;
                    if (charEx[i] == ')')
                        b++;
                }

                if (a == b) {//括号配对后则计算
                    try {
                        if (ex == "")
                            textEx.setText("null");
                        else {
                            ex = "" + sciCal.cal(ex);
                            textEx.setText(ex);
                        }
                    } catch (Exception e) {
                        textEx.setText("error");
                        ex = "";
                    }
                } else
                    textEx.setText("括号不配对");
            }
        });

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        //getMenuInflater()方法可以获得MenuInflater对象
        // 调用inflate方法创建一个菜单
        // 第一个参数：指定资源文件的位置
        // 第二个参数：指定我们的菜单条目要添加到哪一个menu对象中
        return true;        //代表是否可以把菜单显示出来
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        //获取条目的唯一id就可以判断点击的是哪一个条目
        {
            case R.id.conversion:// 单位换算
                Intent intent = new Intent(MainActivity.this, ConversionActivity.class);
                startActivity(intent);
                break;
            case R.id.help:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("注意输入正确的表达式，如显示error请检查表达式并重新输入！").setTitle("帮助");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast t = makeText(MainActivity.this, "用户按下了确认按钮",Toast.LENGTH_SHORT);
                    }
                });
                builder.show();
                break;
            case R.id.money:

                Intent intent1 = new Intent(MainActivity.this, MoneyActivity.class);
                startActivity(intent1);
                break;
            default:
        }
        return true;
    }


}