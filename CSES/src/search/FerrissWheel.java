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

public class FerrissWheel {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> firstLine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long maxWeight = firstLine.get(1);

        List<Long> children = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println(minGondolas(children, maxWeight));
    }

    private static int minGondolas(List<Long> children, long maxWeight){
        int result = 0;
        Collections.sort(children);

        //binary search largest rightmost value

        for(int i = 0; i<children.size(); i++){
            int l = 0;
            int r = children.size()-1;
            int mid = 0;
            int possibleSecond = mid;
            boolean foundPair = false;

            while(l <= r){
                mid = l + ((r-l)/2);
                long childOne = children.get(mid);
                long childTwo = children.get(i);
                if(childOne + childTwo <= maxWeight  && mid != i) {
                    //one possible match, add one to gondola and remove both children from the list
                    //keep looking to the right for bigger possible matches
                    foundPair = true;
                    possibleSecond = mid;
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
            }
            if(foundPair){
                result++;
                if(possibleSecond > i) {
                    children.remove(possibleSecond);
                    children.remove(i);
                }
                else if (possibleSecond < i){
                    children.remove(i);
                    children.remove(possibleSecond);
                }
            }
        }

        //edge case
        if(children.size() == 2){
            int sum = 0;
            for(long i: children)
                sum+=i;
            if(sum <= maxWeight)
                return result+=1;
        }
        result += children.size();

        return result;
    }
}
