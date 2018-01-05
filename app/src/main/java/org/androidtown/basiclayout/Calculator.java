package org.androidtown.basiclayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity {

    // 1. 사용할 위젯을 선언
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btn_plus, btn_minus, btn_multiply, btn_divide, btn_result, btn_re, btn_left, btn_right, btn_dot;
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
        btn_left = (Button) findViewById(R.id.btn_left);
        btn_right = (Button) findViewById(R.id.btn_right);
        btn_dot = (Button) findViewById(R.id.btn_dot);
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
        btn_left.setOnClickListener(onClickListener);
        btn_right.setOnClickListener(onClickListener);
        btn_dot.setOnClickListener(onClickListener);
        textPreview.setOnClickListener(onClickListener);
        textResult.setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            switch (v.getId()) {
                case R.id.btn1:
                    append("1"); //함수를 직접 사용하는 경우는 별로 없다.

                    break;
                case R.id.btn2:
                    append("2");
                    break;
                case R.id.btn3:
                    append("3");
                    break;
                case R.id.btn4:
                    append("4");
                    break;
                case R.id.btn5:
                    append("5");
                    break;
                case R.id.btn6:
                    append("6");
                    break;
                case R.id.btn7:
                    append("7");
                    break;
                case R.id.btn8:
                    append("8");
                    break;
                case R.id.btn9:
                    append("9");
                    break;
                case R.id.btn0:
                    append("0");
                    break;
                case R.id.btn_plus:
                    append("+");
                    break;
                case R.id.btn_minus:
                    append("-");
                    break;
                case R.id.btn_multiply:
                    append("*");
                    break;
                case R.id.btn_left:
                    append("(");
                    break;
                case R.id.btn_right:
                    append(")");
                    break;
                case R.id.btn_dot:
                    append(".");
                    break;
                case R.id.btn_divide:
                    append("/");
                    break;

                case R.id.btn_re:
                    textPreview.setText("");
                    textResult.setText("");
                    break;
                case R.id.btn_result:
                    double result = calc1();
                    textPreview.setText("" + result);
                    break;


            }

        }

        private double calc1() {

            String target = textPreview.getText().toString(); // 계산창의 스트링값들을 가지고 와서, 스트링형태로 바꿔줌
            ArrayList<String> subTarget = new ArrayList<>(); // 어레이리스트에 저장


            String calculTarget[] = target.split("(?<=[*/+-])|(?=[*/+-])"); //계산창의 연산자들을 쪼개준 것을 calculTarget에 저장한다.

            double front, back, subResult, result;

            for (int i = 0; i < calculTarget.length; i++) { // 배열에는 length를 쓴다. // 계산창의 배열의 길이만큼 포문을 돈다.
                if (calculTarget[i].equals("*") || calculTarget[i].equals("/")) { // 배열의 인덱스 중 *,/ 연산자를 만나면
                    front = Double.parseDouble(subTarget.get(subTarget.size() - 1)/*calculTarget[i - 1]*/); // 앞에있는 스트링값(숫자문자)를 더블타입으로 변환해 주고,
                    back = Double.parseDouble(calculTarget[i + 1]);
                    if (calculTarget[i].equals("*")) { //만약 배열의 문자 중 *를 만나면
                        subResult = front * back; // subResult 변수에 double로 형변환된 front와 back을 곱한다.
                    } else {
                        subResult = front / back;// subResult 변수에 double로 형변환된 front와 back을 나눈다.
                    }

                    subTarget.remove(subTarget.size() - 1);// 이 결과로 subTarget.size() 마지막것을 지운다.
                    subTarget.add(subResult + ""); // 마지막것을 지우고, 결과를 리스트 저장 이유는 어

                } else {
                    subTarget.add(calculTarget[i]);// 만약 연산자를 맞닥드리지 않는다면, 그냥 append된 값들을 배열로 변환
                }
            }

            result = Double.parseDouble(subTarget.get(0)); // 첫번째


            for (int k = 0; k < subTarget.size() - 1; k++) { // 어레이리스트에는 size()를 쓴다.
                switch (subTarget.get(k)) {
                    case "+":
                        result += Double.parseDouble(subTarget.get(k + 1));
                        break;
                    case "-":
                        result -= Double.parseDouble(subTarget.get(k + 1));
                }
            }
            return result;
        }


        private void append(String str) {
            if (textPreview.getText().toString().equals("")) {
                if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                    Toast.makeText(Calculator.this, "연산자를 먼저 입력할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    textPreview.setText("");
                }

            }
            textPreview.append(str);
        }
    };


}


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

//        private void calc3(){
//            String inputText ="34+15*3-5/10";
//            String splitedText[] = inputText.split("(?<=[*/+-])|(?=[*/+-])");//정규식을 쓰면됨.
//            String temp[] = {"34", "+","15","*","3", "-","5","-","10"};
//            ArrayList<String> result = new ArrayList<>();
//            for(String item : temp){
//                if(item.equals("*") | item.equals("/")){
//                    //결과값을 result에 add한다.
//                }
//            }
//
//            for(String item : result){}
//        }