package com.example.root.myapplication;

import android.app.Activity;
import android.widget.TextView;

/*
*   途中計算式を表示するクラス
 */

public class Function extends Activity {
    private String m_formula = null;
    private boolean m_bCalcLast = false;     //直近の入力が演算式である
    private static final int LIMIT = 20;    // Function欄の最大文字数を20文字とする

    public void setNum(int num) {
        if(num < 0 || 9 < num ) {   //無効な文字が来た場合
            return;
        }
        if( LIMIT < m_formula.length()){    //表示しきれない場合
            return;
        }
        m_formula += String.valueOf(num);
        m_bCalcLast = false;
        Redraw();
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
        if( LIMIT < m_formula.length()){
            return;
        }
        //演算子が２回続いた場合は更新する
        if(m_bCalcLast) {
            m_formula = m_formula.substring(0,m_formula.length()-1);
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
        m_formula += c;
        m_bCalcLast = true;
        Redraw();
    }

    private void Redraw(){
        TextView display = findViewById(R.id.textView4);
        display.setText(m_formula);
    }
}
