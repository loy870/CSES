package Archive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MissingNumber {

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            solve(n, s);

            bufferedReader.close();
        } catch (Exception e) {

        }
    }

    static void solve(int n, List<Integer> arr) {
        Set<Integer> intSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            intSet.add(i);
        }

        for (int i : arr) {
            if (intSet.contains(i))
                intSet.remove(i);
        }

        for (int i : intSet)
            System.out.println(i);
    }
}
