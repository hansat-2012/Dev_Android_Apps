package com.example.root.myapplication;

// ※メンバに配列使うなら厳密にはTemplateで定義する
/*
 *  後置記法生成のために入力(中置記法)をトークン別にバッファ保持する
 *
 * */
public class StringBuffer {
    static int BUF_TOKEN_SIZE = 20 ;     // Function欄の最大文字数を20文字とする

    // Member:
    public String m_StrIn[ /* BUF_TOKEN_SIZE */ ] ;        // Input token
    public int m_TokenNum = 0 ;        // Input number of tokenes
    public int m_flg_EndOfToken ;   // Token Period
	public String tmp_Str ;
	
    // Method:
    public void resetToken()
    {
        m_StrIn = null;
        m_TokenNum = 0 ;
        m_flg_EndOfToken = 0;
 
	}
    public void saveToken(int tmp_num)
    {
		char tmp_Char = ' ' ;

		// get the present number of an array...
		// m_StrIn.m_TokenLength = m_StrIn.length; 
		// m_StrLength = m_StrIn[0].length(); 

		// generate a token ※符号から始まる数字のトークン化は未実装
        if(tmp_num >= 10)
        {
            if(tmp_num == 10) tmp_Char = '+' ;
            else if(tmp_num == 11) tmp_Char = '-' ;
            else if(tmp_num == 12) tmp_Char = '*' ;
            else if(tmp_num == 13) tmp_Char = '/' ;
            else if(tmp_num == 14) tmp_Char = '.' ;
            else if(tmp_num == 15) tmp_Char = '(';
            else if(tmp_num == 16) tmp_Char = ')';
            //else eUnknownInput = 1;


            m_flg_EndOfToken = 1 ;
        }
        else
        {
            Character.digit(tmp_Char, tmp_num) ; //0 ~ 9

        }

        tmp_Str += tmp_Char;

        // save the token
        if( m_flg_EndOfToken == 1 )
        {
			m_StrIn[ m_TokenNum ] = tmp_Str ;
            m_TokenNum ++;
            tmp_Str = "" ;
            m_flg_EndOfToken = 0 ;

        }
		
    }

}
