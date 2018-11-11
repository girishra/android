package com.example.girish.mycalci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private enum OPERATOR{
        PLUS,SUBTRACT,MULTIPLY,DIVIDE,EQUAL;
    }

    TextView txtCalculations;
    TextView txtResults;
    //instance variable
    private String currentNumber;
    private String numberAtRight;
    private String numberAtLeft;
    private OPERATOR currentOperator;
    private int calculationsResult;
    private String calculationsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentNumber="";
        calculationsResult=0;
        calculationsString="";

        txtCalculations=findViewById(R.id.txt1);
        txtResults=findViewById(R.id.result);
        findViewById(R.id.btnequal).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn7).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn8).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn9).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnplus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn4).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn5).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn6).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnsub).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn1).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn2).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn3).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnmultiply).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnclear).setOnClickListener(MainActivity.this);
        findViewById(R.id.btn0).setOnClickListener(MainActivity.this);
        findViewById(R.id.btndivide).setOnClickListener(MainActivity.this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnequal:
                operatorIsTapped(OPERATOR.EQUAL);
                break;
            case R.id.btn7:
                numberIsTapped(7);
                break;
            case R.id.btn8:
                numberIsTapped(8);
                break;
            case R.id.btn9:
                numberIsTapped(9);
                break;
            case R.id.btnplus:
                operatorIsTapped(OPERATOR.PLUS);
                calculationsString+="+";
                break;
            case R.id.btn4:
                numberIsTapped(4);
                break;
            case R.id.btn5:
                numberIsTapped(5);
                break;
            case R.id.btn6:
                numberIsTapped(6);
                break;
            case R.id.btnsub:
                operatorIsTapped(OPERATOR.SUBTRACT);
                calculationsString+="-";
                break;
            case R.id.btn1:
                numberIsTapped(1);
                break;
            case R.id.btn2:
                numberIsTapped(2);
                break;
            case R.id.btn3:
                numberIsTapped(3);
                break;
            case R.id.btnmultiply:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calculationsString+="*";
                break;
            case R.id.btnclear:
                clearTapped();
                break;
            case R.id.btn0:
                numberIsTapped(0);
                break;
            case R.id.btndivide:
                operatorIsTapped(OPERATOR.DIVIDE);
                calculationsString+="/";
                break;
        }
        txtCalculations.setText(calculationsString);

    }
    private void numberIsTapped(int tappedNumber){
        currentNumber=currentNumber+String.valueOf(tappedNumber);
        txtResults.setText(currentNumber);
        calculationsString=currentNumber;
        txtCalculations.setText(calculationsString);
    }
    private void operatorIsTapped(OPERATOR tappedOperator) {
        if (currentOperator != null) {
            if(currentNumber!="") {


                numberAtRight = currentNumber;
                currentNumber = "";
                switch (currentOperator) {
                    case PLUS:
                        calculationsResult = Integer.parseInt(numberAtLeft) + Integer.parseInt(numberAtRight);
                        break;
                    case SUBTRACT:
                        calculationsResult = Integer.parseInt(numberAtLeft) - Integer.parseInt(numberAtRight);
                        break;
                    case MULTIPLY:
                        calculationsResult = Integer.parseInt(numberAtLeft) * Integer.parseInt(numberAtRight);
                        break;
                    case DIVIDE:
                        calculationsResult = Integer.parseInt(numberAtLeft) / Integer.parseInt(numberAtRight);
                        break;
                }
                numberAtLeft = String.valueOf(calculationsResult);
                txtResults.setText(numberAtLeft);
                calculationsString = numberAtLeft;


            }
        }else {
            numberAtLeft=currentNumber;
            currentNumber="";
        }
        currentOperator=tappedOperator;
    }
    private void clearTapped(){
        numberAtLeft="";
        numberAtRight="";
        calculationsResult=0;
        currentNumber="";
        currentOperator=null;
        txtResults.setText("0");
        calculationsString="0";
    }
}
