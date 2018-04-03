package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_sin,btn_cos,btn_tan;
    Button btn_sqrt,btn_cbrt,btn_clear,btn_del,btn_point,btn_chu,btn_cheng,btn_jian,btn_jia,btn_deng;
    EditText input;
    boolean clear_flag ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input=findViewById(R.id.input);
        input.setKeyListener(null);     // 禁止EditText从键盘输入
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_sqrt = findViewById(R.id.btn_sqrt);
        btn_cbrt = findViewById(R.id.btn_cbrt);
        btn_sin = findViewById(R.id.btn_sin);
        btn_cos = findViewById(R.id.btn_cos);
        btn_tan = findViewById(R.id.btn_tan);
        btn_point = findViewById(R.id.btn_point);
        btn_clear = findViewById(R.id.btn_clear);
        btn_del = findViewById(R.id.btn_del);
        btn_chu = findViewById(R.id.btn_chu);
        btn_cheng = findViewById(R.id.btn_cheng);
        btn_jian = findViewById(R.id.btn_jian);
        btn_jia = findViewById(R.id.btn_jia);
        btn_deng = findViewById(R.id.btn_deng);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_sqrt.setOnClickListener(this);
        btn_cbrt.setOnClickListener(this);
        btn_sin.setOnClickListener(this);
        btn_cos.setOnClickListener(this);
        btn_tan.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_jia.setOnClickListener(this);
        btn_jian.setOnClickListener(this);
        btn_cheng.setOnClickListener(this);
        btn_chu.setOnClickListener(this);
        btn_deng.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String strInput = input.getText().toString();
        switch (v.getId()){
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                if (clear_flag){
                    clear_flag = false;
                    strInput ="";
                    input.setText("");
                }
                input.setText(strInput + ((Button)v).getText());
                break;
            case R.id.btn_sqrt:
                sqrt();
                break;
            case R.id.btn_cbrt:
                cbrt();
                break;
            case R.id.btn_sin:
                sin();
                break;
            case R.id.btn_cos:
                cos();
                break;
            case R.id.btn_tan:
                tan();
                break;
            case R.id.btn_jia:
            case R.id.btn_jian:
            case R.id.btn_cheng:
            case R.id.btn_chu:
                if (clear_flag) {
                    clear_flag =false;
                    strInput ="";
                    input.setText("");
                }
                input.setText(strInput+ " " + ((Button)v).getText()+" ");
                break;
            case R.id.btn_del:
                if (clear_flag) {
                    clear_flag =false;
                    input.setText("");
                }else if (strInput != null && !strInput.equals("")){
                    input.setText(strInput.substring(0,strInput.length()-1));
                }
                break;
            case R.id.btn_clear:
                clear_flag =false;
                input.setText("");
            case R.id.btn_deng:
                getResult();
                break;
                default:
        }
    }

    private void sqrt(){
        String exp = input.getText().toString();
        double d = Double.parseDouble(exp);
        double sqrt=Math.sqrt(d);
        input.setText(sqrt+"");
    }
    private void cbrt(){
        String exp = input.getText().toString();
        double d = Double.parseDouble(exp);
        double cbrt=Math.cbrt(d);
        input.setText(cbrt+"");
    }
    private void tan(){
        String exp = input.getText().toString();
        double d = Double.parseDouble(exp);
        double tan=Math.tan((d/180)*Math.PI);
        input.setText(tan+"");
    }
    private void cos(){
        String exp = input.getText().toString();
        double d = Double.parseDouble(exp);
        double cos=Math.cos((d/180)*Math.PI);
        input.setText(cos+"");
    }
    private void sin(){
        String exp = input.getText().toString();
        double d = Double.parseDouble(exp);
        double sin=Math.sin((d/180)*Math.PI);
        input.setText(sin+"");
    }

    private void getResult() {
        String exp = input.getText().toString();
        if (exp == null||exp.equals("")){
            return;
        }
        if(!exp.contains(" ")) {
            return;
        }
        /*String的contains()方法，判断字符串中是否有某个字符，返回boolean型
        当且仅当此字符串包含指定的char值序列时才返回true。*/
        if (clear_flag){
            clear_flag = false;
            return;
        }
        clear_flag = true;
        double result = 0;
        String s1 = exp.substring(0,exp.indexOf(" ")); //运算符前面的字符串
        String op = exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        String s2 = exp.substring(exp.indexOf(" ")+3);
        /*str.subString( beginIndex, lastIndex) ; 参数含义为从beginIndex处开始截取，在lastIndex前截停。
        比如说“hello world”.subString(0,5);截取到 "hello" ;所以s1应该获得第一个空格前的子字符串，op获
        得第一个空格后的第一个字符，而str.substring(beginIndex): 参数为子串起始下标, 获得从该起始下标到
        字符串末尾的子串，则s2应该是空格后2位字符开始到末尾的字符串。*/
        if (!s1.equals("")&&!s2.equals("")){
            double d1 = Double.parseDouble(s1);//把字符串s1转换成double型浮点数
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")){
                result = d1 + d2;
            }else if (op.equals("-")){
                result = d1 - d2;
            }else if (op.equals("×")){
                result = d1 * d2;
            }else  if (op.equals("÷")){
                if(d2 == 0){
                    result = 0;
                }else {
                    result = d1/d2;
                }
            }
            if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")){
                int r = (int) result;
                input.setText(r+"");  //  ""转成string.
            }else{
                input.setText(result+"");
            }
        }

        else if (!s1.equals("") && s2.equals("")){
            input.setText(exp);
        }

        else if (s1.equals("")&&!s2.equals("")){
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")){
                result = 0 + d2;
            }else  if (op.equals("-")){
                result = 0 - d2;
            }else  if (op.equals("×")){
                result = 0;
            }else  if (op.equals("÷")){
                result = 0;
            }
            if (s2.contains(".")) {
                int r = (int) result;
                input.setText(r+"");
            }else {
                input.setText(result+"");
            }
        }

        else {
            input.setText("");
        }
    }
}
