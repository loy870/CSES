package Archive;

import java.util.Stack;

public class FibStack {
//
//    static int fib(int n){
//        if(n == 1)
//            return 1;
//        if(n == 2)
//            return 2;
//
//        Stack<Integer> fibStack = new Stack<>();
//        fibStack.push(1);
//        fibStack.push(2);
//        n-=2;
//        while(n>0){
//            int first = fibStack.pop();
//            int second = fibStack.pop();
//
//            int fib = first + second;
//            fibStack.push(second);
//            fibStack.push(first);
//            fibStack.push(fib);
//            n--;
//        }
//        return fibStack.peek();
//    }

    static int fib(int a){
        int [] dp = new int[a+1];
        if(a == 0)
            return 0;
        if(a ==1)
            return 1;
        if(a == 2)
            return 2;

        dp[0]=0;
        dp[1]=1;
        dp[2] = 2;
        for(int i=3; i<=a; i++ ){
            dp[i]= dp[i-1] + dp[i-2];
        }

        return dp[a];

    }

    public static void main(String[] args) {
        for(int i= 0; i<=10; i++)
            System.out.println(fib(i));
    }
}
