package Archive;

import java.util.*;

public class KTopFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer/*value*/,Integer/*freq*/> map = new HashMap<>();

        for(int i : nums){
            if(map.containsKey(i)){
                int count = map.get(i);
                map.put(i, ++count);
            }
            else{
                map.put(i,1);
            }
        }

        TreeMap<Integer, List<Integer>> freq = new TreeMap<>();

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<Integer, Integer> entry = it.next();

            if(freq.containsKey(entry.getValue())){
                List<Integer> temp = freq.get(entry.getValue());
                temp.add(entry.getKey());
                freq.put(entry.getValue(), temp);
            }
            else{
                List<Integer> temp = new ArrayList<>();
                temp.add(entry.getKey());
                freq.put(entry.getValue(), temp);
            }
        }

        int[] result = new int[k];

        Iterator<Integer> setIterator = freq.descendingKeySet().iterator();

        List<Integer> resultList = new ArrayList<>();

        while(setIterator.hasNext()){
            resultList.addAll(freq.get(setIterator.next()));
        }

       for(int i = 0 ; i<k; i++){
           result[i] = resultList.get(i);
       }
        return result;
    }
}
