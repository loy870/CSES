package Archive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestTime {

    public static String largestTimeFromDigits(int[] A) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(A).forEach(x -> list.add(x));

        StringBuilder builder = new StringBuilder();

        List<Integer> result = new ArrayList<>(4);

        for (int i = 2; i >= 0; i--) {
            if (list.contains(i)) {
                result.add(0, i);
                list.remove(list.indexOf(i));
                break;
            }
        }
        if (result.size() < 1)
            return "";

        if(list.contains(4) && list.stream().filter(x -> x == 0 ).count() != 2){
            if(result.get(0) == 1 || result.get(0) == 2){

            }
        }



            for (int i = 9; i >= 0; i--) {
                if (list.contains(i)) {
                    if(i>=4 && result.get(0) == 2)
                        continue;
                    result.add(1, i);
                    list.remove(list.indexOf(i));
                    break;
                }

            }

        if (result.size() < 2)
            return "";


        for (int i = 6; i >= 0; i--) {
            if(i==6 && list.contains(i) && !list.contains(0))
                continue;
            if (list.contains(i)) {
                result.add(2, i);
                list.remove(list.indexOf(i));
                break;
            }

        }
        if (result.size() > 3)
            return "";

        if (list.size() == 1) {
            result.add(3, list.get(0));
            for (int i : result) {
                if (builder.length() == 2)
                    builder.append(":");
                builder.append(i);
            }

            return builder.toString();
        } else
            return "";
    }


    public static void main(String[] args) {
        int[] A = {2,0,6,6,};
        System.out.println(largestTimeFromDigits(A));
    }
}
