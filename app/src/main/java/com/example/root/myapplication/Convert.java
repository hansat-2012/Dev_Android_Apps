package com.example.root.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    //#define STACK_MAX  100
    static int STACK_MAX = 100;
    char[] stack = new  char[ STACK_MAX ];
    int   stack_pointer = 0;

    List<String> convert(StringBuffer token ) {
        int n=0,m=0;
        int i = 0;
        String pToken = "" ;
        String[] buffer = new String[ STACK_MAX ] ;        // 並び替えたトークンを格納するバッファ。括弧"(", ")" は除くため、元の式に括弧があればその分長さは短くなる。
        List<String> buffer_list = new ArrayList<String>();


        for (n = 0; n < token.m_TokenNum; n++) {

            // 数字の場合
            if ( isdigit( token.m_StrIn[n] ) ) {
                // 数値ならば、バッファに追加
                buffer[m] = token.m_StrIn[n];
                m++;

            }

            // 数字じゃない場合
            else if ( token.m_StrIn[n] == ")") {
                // '('までスタックからポップし、バッファへ. '(' と ')' は捨てる.
                while ( (pToken = pop() ) != "" && pToken != "(")
                    buffer[n] = pToken;

                if (pToken == "" ) error("'(' がない");

            } else if ( token.m_StrIn[n] == "(" ) {
                push( token.m_StrIn[n] );

            } else if (peek() == "") {
                push( token.m_StrIn[n] );

            } else {
                while (peek() != "") {
                    if ( rank( token.m_StrIn[n] , peek() ) == 1 ) {
                        // 現在のトークンはスタック最上位のトークンより優先順位が低い
                       //buffer += pop();
                       buffer_list.add(pop());

                    } else {
                        push( token.m_StrIn[n] );
                        break;

                    }
                }
            }
        }

        // スタックが空になるまでトークンを取り出し、バッファへ
        while(  i < m ) {
            buffer_list.add(buffer[i]);
            i++;
        }
        while ( (pToken = pop()) != "") {
            if( pToken.equals("=") )
            {
                // do nothing
                error("debug");
            }
            else {
                buffer_list.add( pToken )    ;
            }
        }

        buffer = null;
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

        if( pToken == "")
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
        return stack_pointer > 0 ? String.valueOf(stack[--stack_pointer]) : "" ;
    }

    // 最後にスタックに入ったトークンを返す
    String peek() {
        return stack_pointer > 0 ?  String.valueOf(stack[stack_pointer-1]) : "";
    }

    // 演算子の優先順位を返す
    int rank(String op_a, String op_b) {
        int a = 0;
        int b = 0;

        if (op_a == "(" || op_a == ")") a = 1;
        if (op_a == "*" || op_a == "/" || op_a == "%") a = 4;
        if (op_a == "+" || op_a == "-") a = 5;

        if (op_b == "(" || op_b == ")") b = 1;
        if (op_b == "*" || op_b == "/" || op_b == "%") b = 4;
        if (op_b == "+" || op_b == "-") b = 5;

        return (a < b )? 1: 0;
    }

    void error(String msg) {
        System.out.println("error" + msg );
    }

}
