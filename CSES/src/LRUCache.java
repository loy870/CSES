import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

        HashMap<Integer, Integer> map;
        LinkedList<Integer> list;
        int capacity;

public LRUCache(int capacity) {
        map = new HashMap(capacity);
        list = new LinkedList();
        this.capacity = capacity;
        }

public int get(int key) {
        if(map.containsKey(key)){
            list.remove(new Integer(key));
            list.addFirst(key);
            return map.get(key);
        }
        else
            return -1;
    }

public void put(int key, int value) {
        map.put(key,value);
        if(list.contains(key)){
            list.remove(new Integer(key));
        }
        else{
            if(list.size() == capacity) {
                int evict = list.removeLast();
                map.remove(evict);
            }
        }

        list.addFirst(key);
        }
}
