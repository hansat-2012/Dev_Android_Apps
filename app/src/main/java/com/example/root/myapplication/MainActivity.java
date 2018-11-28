package com.example.root.myapplication;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // button acction
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hoge);

        // button0
        findViewById(R.id.button0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理
                setNum(n);
            }
        });

        // button1
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理
                setNum(n);
            }
        });

        // button2
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理
                setNum(n);
            }
        });

        // button3
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理
                setNum(n);
            }
        });

        // button4
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理
                setNum(n);
            }
        });

        // button5
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理
                setNum(n);
            }
        });

        // button6
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理
                setNum(n);
            }
        });

        // button7
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理
                setNum(n);
            }
        });

        // button8
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理
                setNum(n);
            }
        });

        // button9
        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理
                setNum(n);
            }
        });

        // button_plu
        findViewById(R.id.button_plu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理
                setCalc(n);
            }
        });

        // button_min
        findViewById(R.id.button_min).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理
                setCalc(n);
            }
        });

        // button_mul
        findViewById(R.id.button_mul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理
                setCalc(n);
            }
        });

        // button_div
        findViewById(R.id.button_din).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理
                setCalc(n);
            }
        });


        // button_equ
        findViewById(R.id.button_equ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理

            }
        });

        // button_dot
        findViewById(R.id.button_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(int n) {
                // クリック時の処理

            }
        });


    }

}

