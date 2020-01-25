package com.example.root.myapplication;

// ※メンバに配列使うなら厳密にはTemplateで定義する
/*
 *  後置記法生成のために入力(中置記法)をトークン別にバッファ保持する
 *
 * */
public class StringBuffer {
    static int BUF_TOKEN_SIZE = 100 ;     // Function欄の最大文字数を20文字とする

    // Member:
    public String tmp_Str = "" ;    //単項の作成
    public String[] m_StrIn = new String[  BUF_TOKEN_SIZE  ] ; //各要素に単項と演算子を一つずつ格納
    public int m_TokenNum = 0 ;        // 配列の要素数
    public int m_flg_EndOfToken ;   // Token Period
    private boolean m_bDotUsed = false ;
	
    // Method:

    //トークンのリセット
    public void resetToken()
    {
        m_StrIn  = new String[  BUF_TOKEN_SIZE  ] ;
        m_TokenNum = 0 ;
        m_flg_EndOfToken = 0;
 
	}

	// トークンの保存
    public void saveToken(int tmp_num)
    {

		String tmp_Char  = "" ;

		//演算子が入力された場合
        // *** 演算子を要素に入力する
        if( tmp_num >= 10 && tmp_num != 14)
        {

            // 代数→演算子変換
            if(tmp_num == 10) tmp_Char = "+" ;
            else if(tmp_num == 11) tmp_Char = "-" ;
            else if(tmp_num == 12) tmp_Char = "*" ;
            else if(tmp_num == 13) tmp_Char = "/" ;
            //else if(tmp_num == 14) tmp_Char = "." ;
            else if(tmp_num == 15) tmp_Char = "(";
            else if(tmp_num == 17) tmp_Char = "=";
            //else eUnknownInput = 1;

            //演算子の保存（要素に代入）
            //識別子？のインクリメント
            if(m_TokenNum == 0){    //最初は問答無用でバッファに突っ込む
                // 単項の保存
                if( /*MainActivity.m_bInput_active== */true){
                    m_StrIn[m_TokenNum++] = "0" ;
                }
                else {
                    m_StrIn[m_TokenNum++] = tmp_Str;
                }

                // 演算子の保存
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
            m_bDotUsed = false ;

        } else {

            if( m_bDotUsed && tmp_num == 14 ){  //項のなかで2回以上小数点が押された場合

                return ;    //　何もしない
            }

            // tmc_Char 決定
            if( tmp_num  == 14 )
            {
                int tokennum = m_TokenNum ;
                if (tmp_Str.equals(""))
                {
                    tmp_Char  = "0."; //演算子がトークンの先頭で入力された場合
                }
                else{
                    tmp_Char = ".";
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
            tmp_Str = "" ;
            m_bDotUsed = false ;
            m_flg_EndOfToken = 0 ;


        }

    }

}
