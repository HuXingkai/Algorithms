package xiechengTest;

/**Java实现LRU（最近最少使用）缓存
 * 基础内容：http://wiki.jikexueyuan.com/project/java-collection/linkedhashset.html
 * https://blog.csdn.net/liuzhenfeng/article/details/6254224
 * https://blog.csdn.net/WeiJiaXiaoBao/article/details/79216700
 * Created by andy on 2018/9/4.
 */
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class LRUCache<K, V> {

    int initSize;
    LinkedHashMap<K, V> cache;

    public LRUCache(int size) {
        this.initSize = size;
        this.cache = new LinkedHashMap<K, V>(size, 0.75f, true) {
            private static final long serialVersionUID = 1L;

            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
                return size() > LRUCache.this.initSize;
            }
        };
    }

    public V get(K key) {
        return cache.get(key);
    }

    public V put(K key, V value) {
        return cache.put(key, value);
    }

    public void clear(K key, V value) {
        cache.clear();
    }

    public int size() {
        return cache.size();
    }

    public void getAll() {
        for (Entry<K, V> e : cache.entrySet()) {
            System.out.println(e.getKey() + ";" + e.getValue());
        }
    }

    /**
     * @param args
     */
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LRUCache<Integer, Integer> lruCache = new LRUCache<Integer, Integer>(n);
        while (scanner.hasNext()) {
            String opration = scanner.next();
            if (opration.equals("p")) {
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                lruCache.put(key, value);
            }
            if (opration.equals("g")) {
                int key = scanner.nextInt();
                if (lruCache.get(key) == null) {
                    System.out.println(-1);
                }
                else System.out.println(lruCache.get(key));
            }
        }
    }
}

