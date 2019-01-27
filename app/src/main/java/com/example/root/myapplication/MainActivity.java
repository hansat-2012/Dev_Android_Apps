package com.example.root.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/*test*/

public class MainActivity extends Activity {

    // Instance
    private Function m_func;

    // button action
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // button0
        findViewById(R.id.button0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(0);
            }
        });

        // button1
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(1);
            }
        });

        // button2
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(2);
            }
        });

        // button3
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(3);
            }
        });

        // button4
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(4);
            }
        });

        // button5
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(5);
            }
        });

        // button6
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(6);
            }
        });

        // button7
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(7);
            }
        });

        // button8
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(8);
            }
        });

        // button9
        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(9);
            }
        });

        // button_plu
        findViewById(R.id.button_plu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setCalc(0);
            }
        });

        // button_min
        findViewById(R.id.button_min).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setCalc(1);
            }
        });

        // button_mul
        findViewById(R.id.button_mul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setCalc(2);
            }
        });

        // button_div
        findViewById(R.id.button_div).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setCalc(3);
            }
        });


        // button_equ
        findViewById(R.id.button_equ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setCalc(4);
            }
        });

        // button_dot
        findViewById(R.id.button_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setCalc(5);
            }
        });


    }

}

