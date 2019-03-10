package com.example.root.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*test*/

public class MainActivity extends Activity {

    // Instance
    private Function m_func;
    private StringBuffer m_buf ;
    private Convert m_inputtoken ;
    private RpnCalculator m_convertedtoken ;

    // button action
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_func = new Function();
        m_buf = new StringBuffer();
        m_inputtoken = new Convert();
        m_convertedtoken = new RpnCalculator();

        // button0
        findViewById(R.id.button0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(0);
                m_buf.saveToken(0);

            }
        });

        // button1
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(1);
                m_buf.saveToken(1);

            }
        });

        // button2
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(2);
                m_buf.saveToken(2);

            }
        });

        // button3
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(3);
                m_buf.saveToken(3);

            }
        });

        // button4
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(4);
                m_buf.saveToken(4);

            }
        });

        // button5
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(5);
                m_buf.saveToken(5);

            }
        });

        // button6
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(6);
                m_buf.saveToken(6);

            }
        });

        // button7
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(7);
                m_buf.saveToken(7);

            }
        });

        // button8
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(8);
                m_buf.saveToken(8);

            }
        });

        // button9
        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setNum(9);
                m_buf.saveToken(9);

            }
        });

        // button_plu
        findViewById(R.id.button_plu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setCalc(0);
                m_buf.saveToken(10);

            }
        });

        // button_min
        findViewById(R.id.button_min).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setCalc(1);
                m_buf.saveToken(11);

            }
        });

        // button_mul
        findViewById(R.id.button_mul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setCalc(2);
                m_buf.saveToken(12);

            }
        });

        // button_div
        findViewById(R.id.button_div).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setCalc(3);
                m_buf.saveToken(13);

            }
        });


        // button_equ
        findViewById(R.id.button_equ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setCalc(4);
                m_buf.saveToken(17);
                m_buf.resetToken(); // Trigger of Reset m_buf
//                m_convertedtoken.execute( m_inputtoken.convert( m_buf ) ) ;


            }
        });

        // button_dot
        findViewById(R.id.button_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_func.setCalc(5);
                m_buf.saveToken(14);
                //m_buf[m_buf.m_TokenLength]
            }
        });

        //button_clear
        findViewById(R.id.button_cleaer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                TextView result = findViewById(R.id.txt_result);
                result.setText("");
            }
        });

    }

}

