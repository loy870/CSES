package Archive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {
        List<String> stringList = new ArrayList<>();

        for(int i = 1; i<=n; i++){
            stringList.add(String.valueOf(i));
        }
        Collections.sort(stringList);

        List<Integer> intList = new ArrayList<>();
        stringList.stream().forEach(s -> intList.add(Integer.valueOf(s)));
        return intList;
    }
}
