import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> queue = new ArrayList<>();

        int size = nums.length - k + 1;

        for(int i = 0, j = k; j<=nums.length; i++, j++){
            int temp = Integer.MIN_VALUE;
            for(int idx = i; idx <j; idx++){
                temp = Math.max(temp, nums[idx]);
            }
            queue.add(temp);
        }

        int[] result  = new int[size];
        for(int i = 0; i<size; i++){
            result[i] = queue.get(i);
        }
        return result;
    }
}
