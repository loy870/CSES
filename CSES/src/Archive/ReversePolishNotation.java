package Archive;

import java.util.Stack;

public class ReversePolishNotation {

    public static int evalRPN(String[] tokens) {

        Stack<Integer> operands = new Stack<>();

        for (String s : tokens) {
            if (s.matches("^(\\+|-)?\\d+$"))
                operands.push(Integer.valueOf(s));


                else{
                int a = operands.pop();
                int b = operands.pop();
                if (s == "+") {
                    operands.push(a + b);
                } else if (s == "-") {
                    operands.push(b - a);
                } else if (s == "*") {
                    operands.push(a * b);
                } else if (s == "/") {
                    operands.push(b / a);
                }

            }

        }
        return operands.peek();
    }

        public static void main (String[] args){
            String[] str = {"2", "1", "+", "3", "*"};
            System.out.println(evalRPN(str));

        }
    }
