package com.example.root.myapplication;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class RpnCalculator {

    public String execute(List<String> rpn){

        //System.out.println("--- start RpnCalculator ---");
        if(rpn.isEmpty()) return "";

        Deque<String> RpnStack = new ArrayDeque<>();

        for (String token : rpn){

            if( token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){

                BigDecimal b = new BigDecimal(RpnStack.pop());
                BigDecimal a = new BigDecimal(RpnStack.pop());
                //System.out.println("a = "+ a + ", b = "+ b + ", token = " + token );
                String tmp = calculate(a, b, token);

                RpnStack.push(tmp);

            }else{
                RpnStack.push(token);
            }
        }

        //System.out.println("--- end RpnCalculator ---");
        return RpnStack.pop();
    }

    public String calculate (BigDecimal a, BigDecimal b, String token){
        //System.out.println("--- start exeCalc ---");

        BigDecimal result = new BigDecimal(0);

        switch(token){
            case "+":
                System.out.println(a + " + " + b);
                result = a.add(b);
                break;
            case "-":
                System.out.println(a + " - "  + b);
                result = a.subtract(b);
                break;
            case "*":
                System.out.println(a + " * " + b);
                result = a.multiply(b);
                break;
            case "/":
                System.out.println(a + " / " + b);
                result = a.divide(b, 3, BigDecimal.ROUND_HALF_UP);
                break;
            default:

        }

        //System.out.println("--- end exeCalc ---");
        return result.stripTrailingZeros().toPlainString();

    }

}
