package org.androidtown.basiclayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity {

    // 1. 사용할 위젯을 선언
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btn_plus, btn_minus, btn_multiply, btn_divide, btn_result, btn_re;
    TextView textPreview, textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initView();
        initListner();

    }


    private void initView() {  // 2. 화면과 소스코드를 id로 연결
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_result = (Button) findViewById(R.id.btn_result);
        btn_re = (Button) findViewById(R.id.btn_re);
        textPreview = (TextView) findViewById(R.id.textPreview);
        textResult = (TextView) findViewById(R.id.textResult);
    }

    private void initListner() {
        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);
        btn5.setOnClickListener(onClickListener);
        btn6.setOnClickListener(onClickListener);
        btn7.setOnClickListener(onClickListener);
        btn8.setOnClickListener(onClickListener);
        btn9.setOnClickListener(onClickListener);
        btn0.setOnClickListener(onClickListener);
        btn_plus.setOnClickListener(onClickListener);
        btn_minus.setOnClickListener(onClickListener);
        btn_multiply.setOnClickListener(onClickListener);
        btn_divide.setOnClickListener(onClickListener);
        btn_re.setOnClickListener(onClickListener);
        btn_result.setOnClickListener(onClickListener);
        textPreview.setOnClickListener(onClickListener);
        textResult.setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            switch (v.getId()) {
                case R.id.btn1:
                    setPreview("1"); //함수를 직접 사용하는 경우는 별로 없다.
                    break;
                case R.id.btn2:
                    setPreview("2");
                    break;
                case R.id.btn3:
                    setPreview("3");
                    break;
                case R.id.btn4:
                    setPreview("4");
                    break;
                case R.id.btn5:
                    setPreview("5");
                    break;
                case R.id.btn6:
                    setPreview("6");
                    break;
                case R.id.btn7:
                    setPreview("7");
                    break;
                case R.id.btn8:
                    setPreview("8");
                    break;
                case R.id.btn9:
                    setPreview("9");
                    break;
                case R.id.btn0:
                    setPreview("0");
                    break;
                case R.id.btn_plus:
                    textPreview.setText("+");

                    break;
                case R.id.btn_minus:
                    textPreview.setText("-");


                    break;
                case R.id.btn_multiply:
                    textPreview.setText("*");
                    break;
                case R.id.btn_divide:
                    textPreview.setText("/");
                    break;
                case R.id.btn_re:
                    textPreview.setText("0");
                    textResult.setText("0");
                    break;
                case R.id.btn_result:
                    double result = calc();
                    textPreview.setText("" + result);
                    break;


            }

        }

//        private double calc1() {
//
//            //13 +15*3-5/13
//            //1. 우선순위 없을 경우
//            //가. 입력받을 때 단위별로 공백을 추가해서 받는다.
//            String target = "34+15*-5/3";
//            ArrayList<String> subTarget = new ArrayList<>();
//            //나 공백을 기준으로 spilit하면 연산자와 숫자가 구분된다.
//            String calculTarget[] = target.split(" ");
//            double front, back, subResult, result;
//
//            for (int i = 0; i < calculTarget.length; i++) {
//                if (calculTarget[i].equals("*") || calculTarget.equals("/")) {
//                    front = Double.parseDouble(subTarget.get(subTarget.size() - 1));
//                    back = Double.parseDouble(calculTarget[i + 1]);
//                }
//            }
//        }
//
//        private double calc2(){
//            //저장소를 두개로 분리해서 선언
//            ArrayList<Integer> numberArray = new ArrayList<>();
//            ArrayList<Integer> otherArray = new ArrayList<>();
//            //숫자를 입력되면 텍스트뷰에 숫자를 입력
//            textPreview.append("숫자값");
//            //3. 연산기호가 입력되면 이전에 입력됬던 숫자값을 numberArray에 입력
//            //   연산기호 버튼의 실제아이디를 otherArray에 입력
//
//            //4. 연산기호를 입력했을 때면 배열에 숫자가 입력되므로
//            //
//        }

        private void calc3(){
            String inputText ="34+15*3-5/10";
            String splitedText[] = inputText.split("(?<=[*/+-])|(?=[*/+-])");//정규식을 쓰면됨.
            String temp[] = {"34", "+","15","*","3", "-","5","-","10"};
            ArrayList<String> result = new ArrayList<>();
            for(String item : temp){
                if(item.equals("*") | item.equals("/")){
                    //결과값을 result에 add한다.
                }
            }

            for(String item : result){}
        }

        private void setPreview(String str) {
            String temp = textPreview.getText().toString();

            if (temp.equals("0")) {
                textPreview.setText(str);
            } else {
                textPreview.append(str);
            }

            textPreview.append(str); //기존에 있는값에 더하기 즉, 붙여줄려고
        }
    };


}
