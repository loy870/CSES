package Archive;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> magazineMap = new HashMap<>();
        for(Character e: magazine.toCharArray()){
            if(magazineMap.containsKey(e)){
                magazineMap.put(e, magazineMap.get(e)+1);
            }
            else{
                magazineMap.put(e, 1);
            }
        }

        for(Character e: ransomNote.toCharArray()){
            if(!magazineMap.containsKey(e))
                return false;
            else if(magazineMap.get(e) == 1)
                magazineMap.remove(e);
            else
                magazineMap.put(e, magazineMap.get(e) - 1);
        }
        return true;

    }
}