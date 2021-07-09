package Archive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class BalancedDevelopmentTeams{
    /*
     * Complete the 'maxBalancedTeams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY developers
     *  2. INTEGER maxNewHires
     */

    public static int maxBalancedTeams(List<Integer> developers, int maxNewHires) {
        // Write your code here


        return 0;
    }

}

class Balanced {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int developersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> developers = IntStream.range(0, developersCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int maxNewHires = Integer.parseInt(bufferedReader.readLine().trim());

        int result = BalancedDevelopmentTeams.maxBalancedTeams(developers, maxNewHires);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}