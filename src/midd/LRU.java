package midd;

import java.util.LinkedHashMap;

class LRU {
    int cap;
    //最近使用的元素放在链表尾部，越靠近头，越久没用
    LinkedHashMap<Integer,Integer> cache=new LinkedHashMap<>();

    public LRU(int capacity) {
        this.cap=capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        //将key变为最近使用
        makeRecently(key);
        return cache.get(key);

    }

    public void put(int key, int value) {
        //已存在则覆盖
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, value);
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }
        //满了
        if (cache.size() >= this.cap) {
            // 链表头部就是最久未使用的 key
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        // 将新的 key 添加链表尾部
        cache.put(key, value);
    }
    private void makeRecently(int key){
        int val=cache.get(key);
        //删除key，重新插入到队尾
        cache.remove(key);
        cache.put(key,val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
