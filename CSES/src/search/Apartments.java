package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Apartments {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> firstLine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int maxDiff = firstLine.get(2);

        List<Integer> apartments = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));


        List<Integer> desiredSizes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        System.out.println(findNumApartments(apartments, desiredSizes, maxDiff));
    }

    private static int findNumApartments(List<Integer> apartments, List<Integer> desiredSize, int maxDifference){

        Collections.sort(apartments);
        int result = 0;

        for(int size: desiredSize){
            //binary search the list of apartments
            int l = 0;
            int r = apartments.size() -1;

            while(l<=r){
                int mid = l+((r-l)/2);
                if(apartments.get(mid) <= size + maxDifference && apartments.get(mid) >= size - maxDifference){
                    result++;
                    apartments.remove(mid);
                    break;
                }

                if(apartments.get(mid) > size + maxDifference){
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }

        }
        return result;
    }
}
