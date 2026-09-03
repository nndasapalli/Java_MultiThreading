package advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Advanced 8. Thread-Safe LRU Cache
 * Build a fixed-capacity LRU cache on top of LinkedHashMap's access-order
 * mode, guarded by a ReentrantLock so concurrent get/put calls stay
 * consistent and evict the least-recently-used entry once full.
 **/
public class Task8 {
    static class LruCache<K, V> {
        private final int capacity;
        private final Map<K, V> map;
        private final ReentrantLock lock = new ReentrantLock();

        LruCache(int capacity) {
            this.capacity = capacity;
            this.map = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                    return size() > LruCache.this.capacity;
                }
            };
        }

        V get(K key) {
            lock.lock();
            try {
                return map.get(key);
            } finally {
                lock.unlock();
            }
        }

        void put(K key, V value) {
            lock.lock();
            try {
                map.put(key, value);
            } finally {
                lock.unlock();
            }
        }

        @Override
        public String toString() {
            lock.lock();
            try {
                return map.toString();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        // Write your code here
        LruCache<Integer, String> cache = new LruCache<>(3);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.get(1);
        cache.put(4, "four");
        System.out.println("cache : " + cache);
    }
}
