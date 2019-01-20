package com.example.root.myapplication;

import android.app.Activity;

/*
*  後置記法の文字列を生成する
*  入力は"="までの数式＠入力順(中置記法) (Object:StringBuffer)
*  (具体的には、数字、+、-、*、/　のいずれかのトークンが入る)
*  スタック（m_Stack）・・・・・演算子が入るバッファ
*  バッファ（m_Buffer）・・・・・数字が入るバッファ
*
* */
public class GenPolishStr extends Activity {
    //Member:
    private String m_Token, m_Stack, m_Buffer ;
    private boolean m_Exit ;
    private int m_LoopNum ;

    //Methods:
    public void genPolishString(StringBuffer m_InputToken)
    {
        // Reset
        m_LoopNum = 0 ;
        m_Buffer = "" ;
        m_Stack  = "" ;
        m_Exit = false;

        while ( m_LoopNum <= m_InputToken.m_StrIn.length  )
        {

            //式から１トークン取り出す
            m_Token = String.valueOf( m_InputToken.m_StrIn[m_LoopNum] );

            // 1文字ずつ中置ー＞後置記法アルゴリズムに入力
            for( int i = 0; i <= m_Token.length() ; i++ )
            {

                // まだ文字があるか
                if ( i == m_Token.length() )//もう文字がない
                {
                    /* ①スタックが空になるまでポップ */
                    /* ②①をバッファへ */
                    /* ③終了処理 */

                }
                else //まだ文字がある
                {

                    // 数字かどうか
                    if ( IsChar( m_Token.substring(0,i) ) ) //数字
                    {
                        m_Buffer = String.valueOf(m_Token) ;  //トークンをバッファに追加
                    }
                    else    //数字じゃない
                    {
                        // ）かどうか
                        if (m_Token.substring(0,i) == ")")
                        {
                            /* ①（までスタックからポップ */
                            /* ②それをバッファへ */
                            /* ③（と）を捨てる */

                        }
                        else  // )じゃない
                        {

                            // （ かどうか
                            if (m_Token.substring(0,i) == "(") {
                                m_Stack = String.valueOf( m_InputToken.m_StrIn );    //トークンをスタックに追加

                            }
                            else    // ( じゃない
                            {
                                //スタックの最上段の演算子 > トークン演算子　となるまで続ける・・・A
                                while (!m_Exit)
                                {
                                    //スタックが空かどうか
                                    if (m_Stack == null)     //空の場合
                                    {
                                        m_Stack += String.valueOf( m_Token.substring(0,i) );       //トークンをスタックに追加

                                    } else    //空じゃない場合
                                    {

                                        //優先順位
                                        if (JudgePrior( m_Token.substring(0,i) , m_Stack ) )    // スタック最上段演算子 ≦ トークン演算子
                                        {
                                            /* スタックからポップ */
                                            /* それをバッファへ */

                                        }
                                        else    // スタック最上段演算子 > トークン演算子　・・・A
                                        {
                                            m_Stack += String.valueOf( m_Token );    //トークンをスタックに追加
                                            m_Exit = true;

                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }

            // save the strings written in polish
            /* 後置記法の文字列を保存する
             * （＝StackとBufferに収まっている値と演算子を組み合わせる）
             * */
            m_LoopNum ++ ;

        }
    }
    public boolean IsChar(String tmp_buf_char )
    {
        // 数字だったらTRUEを返す
        switch( String.valueOf(tmp_buf_char) )
        {
            case "0": return true ;
            case "1": return true ;
            case "2": return true ;
            case "3": return true ;
            case "4": return true ;
            case "5": return true ;
            case "6": return true ;
            case "7": return true ;
            case "8": return true ;
            case "9": return true ;
            case ".": return true ;
            case "+": return false ;
            case "-": return false ;
            case "*": return false ;
            case "/": return false ;
            case "(": return false ;
            case ")": return false ;
            default:
            /* 何らかの以上終了処理*/
            break ;
        }

        return false ;
    }
    public boolean JudgePrior(String tmp_Token, String tmp_Stack)
    {
        int tmp_present_prior_level = 0 ;
        int tmp_next_prior_level = 0 ;

        // previous
        switch( tmp_Token )
        {
            case "+":
                tmp_next_prior_level = 1 ;
                break;
            case "-":
                tmp_next_prior_level = 1 ;
                break;
            case "*":
                tmp_next_prior_level = 2 ;
                break;
            case "/":
                tmp_next_prior_level = 2 ;
                break;
            default:
                /* 何らかの以上終了処理*/
                break;
        }
        // next
        switch( tmp_Stack.substring(0, tmp_Stack.length()-1 ) )
        {
            case "+":
                tmp_next_prior_level = 1 ;
                break;
            case "-":
                tmp_next_prior_level = 1 ;
                break;
            case "*":
                tmp_next_prior_level = 2 ;
                break;
            case "/":
                tmp_next_prior_level = 2 ;
                break;
            default:
                /* 何らかの以上終了処理*/
                break;
        }

        if( tmp_next_prior_level > tmp_present_prior_level)
        {
            tmp_present_prior_level = tmp_next_prior_level ;
            return true ;

        }

        return false ;
    }


}
