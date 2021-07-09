package Archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class BitWisePairs {


    /*
     * Complete the 'countPairs' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long countPairs(List<Integer> arr) {
        int result = 0;
        for(int i = 0; i<arr.size(); i++){
            for(int j = i+1; j<arr.size(); j++){
                int bitwise = (arr.get(i).intValue() & arr.get(j).intValue());
                int temp = bitwise & (bitwise-1);
                if(temp == 0 && bitwise != 0)
                    result++;
            }
        }

        return result;

    }

}

 class BitWise {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long result = BitWisePairs.countPairs(arr);

       System.out.println(String.valueOf(result));


        bufferedReader.close();
    }

}

