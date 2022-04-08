import java.util.Map;
import java.util.Map.Entry;

/*
    This is the implementation of LRU Cache using LinkedHashMap
*/

public class Map_LinkedHashMap_LRUCache {
    public static void main(String[] args) {

        Map<Integer, String> lruCache = new LRUCache();

        lruCache.put(1784, "The Godfather");
        lruCache.put(1202, "Titanic");
        lruCache.put(1503, "Jaws");
        lruCache.put(1501, "Saving Private Ryan");
        lruCache.put(2501, "Back to the Future");

        System.out.println("Added exactly 5 entries\n");

        for (Entry<Integer, String> entry : lruCache.entrySet()) {
            System.out.println(entry);
        }

        // These 2 entries will be added to be the last 2 items in the cache
        // The first 2 entries of id 1784 & 1202 (least frequently used) will be removed
        // due to cache limitation = 5 items
        lruCache.put(3000, "The Parasite");
        lruCache.put(4000, "It's a Beautiful Life");


        System.out.println("\nOnly the 5 most recently accessed entries will be preserved\n");

        for (Entry<Integer, String> entry : lruCache.entrySet()) {
            System.out.println(entry);
        }

        // Run
        // These 2 items will be placed to the last 2 items in the cache
        // They become frequently used items
        lruCache.get(1503);
        lruCache.get(2501);

        System.out.println("\nAccessed Jaws and Back to the Future");

        for (Entry<Integer, String> entry : lruCache.entrySet()) {
            System.out.println(entry);
        }
    }
}
