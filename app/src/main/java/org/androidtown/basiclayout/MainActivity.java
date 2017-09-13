package org.androidtown.basiclayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//안드로이드 화면구조              Fragment(화면조각)
// App(어플) > Activity(화면한개단위) > Layout(뷰그룹:컨테이너) > Widget(뷰)

public class MainActivity extends AppCompatActivity { // Activity 기반클래스를 // 상속받아서 구성된다.

    //1. 레이아웃에 정의된 웨젯의 아이디로 해당 객체를 변수에 저장해둔다.
    Button btnFrame, btnLinear, btnGrid, btnRelative, btnCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. 선언된 변수에 실제 위젯을 할당
        btnFrame = (Button) findViewById(R.id.btnFrame);
        btnLinear = (Button) findViewById(R.id.btnLinear);
        btnGrid = (Button) findViewById(R.id.btnGrid);
        btnRelative = (Button) findViewById(R.id.btnRelative);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        // 3. 위에서 저장한 변수를 사용
        // 아래에 선언한 실행객체를 리스너에 던져준다.
        btnFrame.setOnClickListener(onClickListener);
        btnLinear.setOnClickListener(onClickListener);
        btnGrid.setOnClickListener(onClickListener);
        btnRelative.setOnClickListener(onClickListener);
        btnCalculate.setOnClickListener(onClickListener);
        //findViewById(R.id.btnFrame).setOnClickListener(onClickListener);
    }




    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // 액티비티(메이저 컴포넌트) 실행
            // 1. 인텐트(시스템에 전달되는 메시지객체) 생성
            // 인텐트 객체 안에는 컨텍스트라는 시스템 자원이 들어가야함.
            // this는 자기가 가장 가까운 곳을 지칭
            //                Intent intent = new Intent(MainActivity.this, FrameActivity.class);
            //                startActivity(intent);

            Intent intent = null;

            switch (v.getId()) {
                case R.id.btnFrame:
                    intent = new Intent(MainActivity.this, FrameActivity.class);
//                        startActivity(intent);
                    break;
                case R.id.btnLinear:
                    intent = new Intent(MainActivity.this, LinearActivity.class);
//                        startActivity(intent);
                    break;
                case R.id.btnGrid:
                    intent = new Intent(MainActivity.this, GridActivity.class);
//                        startActivity(intent);
                    break;
                case R.id.btnRelative:
                    intent = new Intent(MainActivity.this, RelativeActivity.class);
//                        startActivity(intent);
                    break;
                case R.id.btnCalculate:
                    intent = new Intent(MainActivity.this, Calculator.class);
            }
            startActivity(intent);
        }
    };


}

