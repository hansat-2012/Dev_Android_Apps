package com.example.root.myapplication;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.List;

/*test*/

public class MainActivity extends Activity {

    // Instance
    private StringBuffer m_buf ;
    private Convert m_inputtoken ;
    private RpnCalculator m_convertedtoken ;
    private TextView m_txtResult;
    private String m_dispStr; //リザルトバーに表示するようの文字列
    private boolean m_bCalcLast = false;     //直近の入力が演算式である

    private boolean m_bZero;    //表示されている値が0
    private boolean m_bDot; //計算式にdotが使われてるか。(dotは1つまで)

    // button action
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        m_buf = new StringBuffer();
        m_inputtoken = new Convert();
        m_convertedtoken = new RpnCalculator();
        m_txtResult = findViewById(R.id.txt_result);
        m_txtResult.setText("0");
        m_dispStr = "0";
        m_bZero = true;
        m_bDot = false;
        // button0
        findViewById(R.id.button0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                clickNum(0);
            }
        });

        // button1
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                clickNum(1);
            }
        });

        // button2
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                clickNum(2);
            }
        });

        // button3
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                clickNum(3);
            }
        });

        // button4
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                clickNum(4);
            }
        });

        // button5
        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                clickNum(5);
            }
        });

        // button6
        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                clickNum(6);
            }
        });

        // button7
        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                clickNum(7);
            }
        });

        // button8
        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                clickNum(8);
            }
        });

        // button9
        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                clickNum(9);
            }
        });

        // button_plu
        findViewById(R.id.button_plu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                setCalc(0);
                m_buf.saveToken(10);

            }
        });

        // button_min
        findViewById(R.id.button_min).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                setCalc(1);
                m_buf.saveToken(11);

            }
        });

        // button_mul
        findViewById(R.id.button_mul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                setCalc(2);
                m_buf.saveToken(12);

            }
        });

        // button_div
        findViewById(R.id.button_div).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                setCalc(3);
                m_buf.saveToken(13);

            }
        });


        // button_equ
        findViewById(R.id.button_equ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                setCalc(4);
                m_buf.saveToken(17);
                m_convertedtoken.execute( m_inputtoken.convert( m_buf ) ) ;
                Convert e_con = new Convert();
                List<String> st_con = e_con.convert(m_buf);
                m_buf.resetToken(); // Trigger of Reset m_buf
                RpnCalculator e_rpn = new RpnCalculator();
                String e_result = e_rpn.execute(st_con);
                TextView result = findViewById(R.id.txt_result);
                result.setText(e_result);
            }
        });

        // button_dot
        findViewById(R.id.button_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                if(m_bDot){
                    return;
                }
                m_bDot = true;
                if(m_bZero){    //TODO:計算に使うバッファの方でいきなりdotを押した時の処理とか考えなきゃいかんかも
                    m_bZero = false;
                }
                m_dispStr += ".";
                m_txtResult.setText(m_dispStr);
                setCalc(5);
                m_buf.saveToken(14);
                //m_buf[m_buf.m_TokenLength]
            }
        });

        //button_clear
        findViewById(R.id.button_cleaer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View n) {
                // クリック時の処理
                m_bZero = true;
                m_bDot = false;
                m_dispStr = "0";
                m_txtResult.setText(m_dispStr);
            }
        });
    }

    void clickNum(int num){
        if(num == 0 && m_bZero){    //現在の計算値が0の時は0を表示させない
            return;
        }
        if(num != 0 && m_bZero){
            m_dispStr = ""; //最初から表示されてる0を消したいので一旦クリア
            m_bZero = false;
        }
        if(16 < m_dispStr.length()) {
            return; //字数制限。ひとまず9桁まで
        }
        showNum(num);
        m_buf.saveToken(num);
        m_bCalcLast = false;
    }

    void showNum(int num){
        m_dispStr += String.valueOf(num);
        m_txtResult.setText(m_dispStr);
    }
    /*
     * 0 : +
     * 1 : -
     * 2 : *
     * 3 : /
     * 4 : =
     * 5 : .
     */
    public void setCalc(int calc) {
        if(calc < 0 || 5 < calc) {
            return;
        }
        //TODO:演算子が２回続いた場合は更新する
        if(m_bCalcLast) {
            m_dispStr = m_dispStr.substring(0,m_dispStr.length()-1);
        }

        char c;
        switch(calc) {
            case 0:
                c = '+';
                break;
            case 1:
                c = '-';
                break;
            case 2:
                c = '*';
                break;
            case 3:
                c = '/';
                break;
            case 4:
                c = '=';
                break;
            case 5:
                c = '.';
                break;
            default:
                return;
        }
        m_dispStr += c;
        m_txtResult.setText(m_dispStr);
        m_bCalcLast = true;
    }
}

