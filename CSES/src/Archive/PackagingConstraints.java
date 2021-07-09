package Archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class PackagingConstraints {

    static class Result {

        /*
         * Complete the 'findDolls' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY size as parameter.
         */

        public int findDolls(List<Integer> boxes) {
            // Write your code here
            int result = 0;
            Collections.sort(boxes);
            boolean[] hasBox = new boolean[boxes.size()];
            int nestedBoxes = 0;
            for(int i: boxes){
                int bigBox = Collections.binarySearch(boxes, i * 2, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                      if(o1.intValue() >= o2.intValue())
                          return 1;
                      else
                          return -1;
                    }
                }); //find lower bound of 2x box size
                if(bigBox > 0 && !hasBox[bigBox]){
                    nestedBoxes++;
                    hasBox[bigBox] = true;
                }
            }



            return boxes.size() - nestedBoxes;

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sizeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> size = IntStream.range(0, sizeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = new Result().findDolls(size);

       System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}
