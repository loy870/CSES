package Archive;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class BearAndSteadyGene {

    static int steadyGene(String gene) {

        Map<Character, Integer> geneMap = new HashMap<>();

        for (char c : gene.toCharArray()) {
            if (!geneMap.containsKey(c))
                geneMap.put(c, 0);
            else {
                int freq = geneMap.get(c);
                geneMap.put(c, freq + 1);
            }
        }

       Iterator<Map.Entry<Character,Integer>> iterator = geneMap.entrySet().iterator();

        int result = 0;
        while(iterator.hasNext()){
            Map.Entry<Character,Integer> entry = iterator.next();
            int occurrence = entry.getValue() - (gene.length()/4);
            result += occurrence > 0 ? occurrence : 0;
        }
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        String gene = scanner.nextLine();
//
//        int result = steadyGene(gene);
//
//        System.out.println(String.valueOf(result));
//
//
//        scanner.close();

        String path = "/users/bob";
        String[] paths = path.split("/");
        StringBuilder str = new StringBuilder();
        str.append("/" + paths[1]);
        System.out.println(str.toString());
    }
}
