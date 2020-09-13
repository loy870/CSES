import java.util.Stack;

public class FibStack {

    static int fib(int n){
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;

        Stack<Integer> fibStack = new Stack<>();
        fibStack.push(1);
        fibStack.push(2);
        n-=2;
        while(n>0){
            int first = fibStack.pop();
            int second = fibStack.pop();

            int fib = first + second;
            fibStack.push(second);
            fibStack.push(first);
            fibStack.push(fib);
            n--;
        }
        return fibStack.peek();
    }

    public static void main(String[] args) {
        System.out.println(fib(3));
    }
}
