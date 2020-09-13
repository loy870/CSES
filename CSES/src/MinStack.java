import javax.swing.text.html.Option;
import java.util.*;

public class MinStack {

    /** initialize your data structure here. */

    Stack<Integer> stack;
    int min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        min = stack.stream().min(Comparator.comparing(Integer::intValue)).get();
    }

    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
            if (stack.stream().min(Comparator.comparing(Integer::intValue)).isPresent())
                min = stack.stream().min(Comparator.comparing(Integer::intValue)).get();
        }
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
        if(!stack.isEmpty())
             return min;
        else
            return 0;
    }

    Map<Character, Character> chars = new HashMap<>();

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */