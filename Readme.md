# ADS04 Android

## 수업 내용

- 사칙연산이 가능한 계산기 레이아웃 과 로직을 구현하는 미니 프로젝트

## Code Review

```Java
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
```


## 보충설명

- UI에서 보이는 계산기 숫자를 클릭시 '문자로 구성된 숫자들'은 append라고 명명한 메서드를 통해 출력된다. (연산자를 먼저 입력할 수 없는 에외처리 + 만약 숫자가 먼저 입력되면 그냥 append를 통해 문자형태로 누적?추가?됨.)

- 실질 적인 계산은 btn_result가 클릭되었을 때 실행됨.
- 우선 숫자들을 저장할 수 있는 어레이리스트 객체를 생성함.
- 그리고 String 형태로 들어오는 숫자들을 배열에 담고 정규식을 사용함.
- 정규식의 내용인
```Java
.split("(?<=[*/+-])|(?=[*/+-])")
```
- [~~~] 에 담긴 문자들을 만나면 쪼개준다?라는 뜻이다.
- 그리고 곱하기, 나누기 연산과 더하기, 빼기 연산을 나눠준다.
- 우선 배열의 크기만큼 반복문을 돌고, 곱하기, 나누기 부호를 만나면, 'parse타입'으로 연산에 필요한 타입으로 나눠준후, 숫자 연산을 진행한다.

- 수정필요!

- __배열과 어레이리스트를 같이 사용할 필요가 있는지 고려가 필요함.__

## TODO

- 괄호와 소수점 추가하기

## Retrospect

- 알고리즘이 굉장히 많이 들어간다고 느꼈던 프로젝트이다.

## Output
- ![calculate](https://user-images.githubusercontent.com/31605792/36633326-e3a74b90-19d6-11e8-893d-a5bc004d9045.gif)





