package com.example.root.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    //#define STACK_MAX  100
    static int STACK_MAX = 100;
    char[] stack = new  char[ STACK_MAX ];
    int   stack_pointer = 0;

    List<String> convert(StringBuffer token ) {
        int n = 0, m = 0;
        int i = 0;

        String pToken = "" ;
        List<String> buffer_list = new ArrayList<String>()  ;       // 並び替えたトークンを格納するバッファ。括弧"(", ")" は除くため、元の式に括弧があればその分長さは短くなる。

        for (n = 0; n < token.m_TokenNum; n++) {

            // もう文字が無い
            if ( token.m_StrIn[n].equals("") ) {
                break;
            }

            /* 数字の場合 ===============================================================*/
            else if ( isdigit( token.m_StrIn[n] ) ) {
                // 数値ならば、バッファに追加
                buffer_list.add(token.m_StrIn[n]);

            }

            /* 数字じゃない場合 ===============================================================*/
/*
            // トークンは')'か？
            else if ( token.m_StrIn[n].equals(")")) {

                // '('がある場合
                // *** '('までスタックからポップし、バッファへ.
				// *** '(' と ')' は捨てる.
                pToken = pop();
                while ( !pToken.equals("") && !pToken.equals("(") ){
                //while ( (pToken = pop() ) != "" && pToken != "(")
                    buffer_list.add(token.m_StrIn[n]);
                    pToken = pop();

                }

                // '('がない場合
                if (pToken.equals( "") ) error("'(' がない");

            }

            // トークンは'('か？
            else if ( token.m_StrIn[n].equals( "(" )) {

                push( token.m_StrIn[n] );// トークンをスタックに追加

            }
*/

            // その他（演算子処理）
            else {

                if (peek().equals("")) {  // スタックは空か
                    push(token.m_StrIn[n]);
                }

                // スタックは空ではない
                else
                {

                    // スタックが空になるまで、もしくはトークンより低順位の演算子にめぐりあうまで以下を繰り返す
                    while (!peek().equals("") & !peek().equals("=") ) {
                        if (rank(peek(), token.m_StrIn[n]) == 1) { // 現在のトークンはスタック最上位のトークンより優先して演算されるべき

                            buffer_list.add(pop());

                        }
                        else {
                            break;
                        }

                    }

                    // スタックが空になった場合、トークンを追加して終了する
                    push(token.m_StrIn[n]);

                }


            }
        }

        // スタックが空になるまでトークンを取り出し、バッファへ
        //while ( !(pToken = pop()).equals(""))
        n = 0 ;
        while ( n < stack.length   )
        {

            pToken = pop()  ;
            if( pToken.equals("") ){
                break;
            }
            else if( pToken.equals("=")  )
            {

            }
            else
            {
                buffer_list.add( pToken )     ;
            }

            n++ ;
        }

        return buffer_list ;

    }

    /********************************************************************************************/

    // 数字かどうか判定する
    boolean isdigit(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // push＝スタックに追加
    void push(String pToken) {
        char[] tmp = new char[ 1 ] ;   // 演算子一つずつ扱うため要素数１

        if( pToken.equals(""))
        {
            // do nothing
            error("debug");
        }
        else {
            tmp = pToken.toCharArray();

            if (stack_pointer >= STACK_MAX) error("stack full");
            stack[stack_pointer++] = tmp[0];
        }

    }

    // スタックから１トークン取り出す
    String pop() {
        String a;

        a = stack_pointer > 0 ? String.valueOf(stack[--stack_pointer]) : "";
        stack[stack_pointer] = ' ' ;

        return a ;
    }

    // 最後にスタックに入ったトークンを返す
    String peek() {
        return stack_pointer > 0 ?  String.valueOf(stack[stack_pointer-1]) : "";
    }

    // 演算子の優先順位を返す
    int rank(String op_a, String op_b) {
        int a = 0;
        int b = 0;

        if (op_a.equals("(") || op_a.equals(")")) a = 1;
        if (op_a.equals("*") || op_a.equals("/") || op_a.equals( "%")) a = 4;
        if (op_a.equals("+") || op_a.equals("-")) a = 5;

        if (op_b.equals("(") || op_b.equals(")")) b = 1;
        if (op_b.equals("*") || op_b.equals("/") || op_b.equals( "%")) b = 4;
        if (op_b.equals("+") || op_b.equals("-")) b = 5;

        return (a < b )? 1: 0;
    }

    void error(String msg) {
        System.out.println("error" + msg );
    }

}
