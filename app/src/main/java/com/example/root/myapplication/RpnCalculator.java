package com.example.root.myapplication;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class RpnCalculator {

    public String execute(List<String> rpn){

        //System.out.println("--- start RpnCalculator ---");

        Deque<Double> RpnStack = new ArrayDeque<>();

        for (String token : rpn){

            if( token == "+" || token == "-" || token == "*" || token == "/"){

                double b = RpnStack.pop();
                double a = RpnStack.pop();
                //System.out.println("a = "+ a + ", b = "+ b + ", token = " + token );
                double tmp = calculate(a, b, token);

                RpnStack.push(tmp);

            }else{
                RpnStack.push(Double.valueOf(token));
            }
        }

        //System.out.println("--- end RpnCalculator ---");
        return RpnStack.pop().toString();
    }

    public double calculate (double a, double b, String token){
        //System.out.println("--- start exeCalc ---");

        double result = 0;

        switch(token){
            case "+":
                System.out.println(a + " + " + b);
                result = a + b ;
                break;
            case "-":
                System.out.println(a + " - "  + b);
                result = a - b;
                break;
            case "*":
                System.out.println(a + " * " + b);
                result = a * b;
                break;
            case "/":
                System.out.println(a + " / " + b);
                result = a / b;
                break;
            default:

        }

        //System.out.println("--- end exeCalc ---");
        return result;

    }

}
