package com.example.root.myapplication;

// ※メンバに配列使うなら厳密にはTemplateで定義する
/*
 *  後置記法生成のために入力(中置記法)をトークン別にバッファ保持する
 *
 * */
public class StringBuffer {
    static int BUF_TOKEN_SIZE = 100 ;     // Function欄の最大文字数を20文字とする

    // Member:
    public String[] m_StrIn = new String[  BUF_TOKEN_SIZE  ] ;        // Input token
    public int m_TokenNum = 0 ;        // Input number of tokenes
    public int m_flg_EndOfToken ;   // Token Period
    public String tmp_Str = "" ;
    private boolean m_bDotUsed = false ;
	
    // Method:
    public void resetToken()
    {
        m_StrIn  = new String[  BUF_TOKEN_SIZE  ] ;
        m_TokenNum = 0 ;
        m_flg_EndOfToken = 0;
 
	}
    public void saveToken(int tmp_num)
    {

		String tmp_Char  = "" ;

		// get the present number of an array...
		// m_StrIn.m_TokenLength = m_StrIn.length; 
		// m_StrLength = m_StrIn[0].length(); 

		// generate a token ※符号から始まる数字のトークン化は未実装
        if( tmp_num >= 10 && tmp_num != 14)
        {

            if(tmp_num == 10) tmp_Char = "+" ;
            else if(tmp_num == 11) tmp_Char = "-" ;
            else if(tmp_num == 12) tmp_Char = "*" ;
            else if(tmp_num == 13) tmp_Char = "/" ;
            //else if(tmp_num == 14) tmp_Char = "." ;
            else if(tmp_num == 15) tmp_Char = "(";
            else if(tmp_num == 17) tmp_Char = "=";
            //else eUnknownInput = 1;

            if(m_TokenNum == 0){    //最初は問答無用でバッファに突っ込む
                m_StrIn[m_TokenNum++] = tmp_Str;
                m_StrIn[m_TokenNum++] = tmp_Char;
            }else {

                int tokennum = m_TokenNum - 1;
                if (tmp_Str.equals("") && ((m_StrIn[tokennum].equals("+")) || (m_StrIn[tokennum].equals("-")) || m_StrIn[tokennum].equals("*") || m_StrIn[tokennum].equals("/") || m_StrIn[tokennum].equals(".") || m_StrIn[tokennum].equals("="))) {
                    m_StrIn[tokennum] = tmp_Char; //演算子が連続で入力された場合はを入れ直す
                } else {
                    m_StrIn[m_TokenNum++] = tmp_Str;    //ソースコードが重複してるのでできれば修正
                    m_StrIn[m_TokenNum++] = tmp_Char;
                }
            }
            tmp_Str = "" ;
        } else {

            if( m_bDotUsed && tmp_num == 14 ){

                return ;
            }

            // tmc_Char 決定
            if( tmp_num  == 14 )
            {
                int tokennum = m_TokenNum - 1;
                if (tmp_Str.equals("") && ((m_StrIn[tokennum].equals("+")) || (m_StrIn[tokennum].equals("-")) || m_StrIn[tokennum].equals("*") || m_StrIn[tokennum].equals("/") || m_StrIn[tokennum].equals(".") || m_StrIn[tokennum].equals("="))) {
                    tmp_Char  = "0."; //演算子が連続で入力された場合
                }
                else{
                    tmp_Char = "."  ;
                }
                m_bDotUsed = true ;

            }
            else {
                tmp_Char = String.valueOf(tmp_num); //0 ~ 9
            }

            tmp_Str += tmp_Char;
        }



        //
        if (tmp_Char == "=" ){
            m_flg_EndOfToken = 1 ;

        }

        // save the token
        if( m_flg_EndOfToken == 1 )
        {
			m_StrIn[ m_TokenNum ] = tmp_Str ;
            m_TokenNum ++;
            m_bDotUsed = false ;
            tmp_Str = "" ;
            m_flg_EndOfToken = 0 ;


        }

    }

}
