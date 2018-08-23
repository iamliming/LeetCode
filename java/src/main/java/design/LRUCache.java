package design;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * @author liming
 * @version [版本号, 八月 21, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
class CacheNode
{
    private Integer key;

    private Integer value;

    private CacheNode prev;

    private CacheNode next;

    public Integer getKey()
    {
        return key;
    }

    public void setKey(Integer key)
    {
        this.key = key;
    }

    public Integer getValue()
    {
        return value;
    }

    public void setValue(Integer value)
    {
        this.value = value;
    }

    public CacheNode getPrev()
    {
        return prev;
    }

    public void setPrev(CacheNode prev)
    {
        this.prev = prev;
    }

    public CacheNode getNext()
    {
        return next;
    }

    public void setNext(CacheNode next)
    {
        this.next = next;
    }
}

public class LRUCache
{
    private int capacity;

    private int count = 0;

    private Map<Integer, CacheNode> map;

    private CacheNode head, tail;

    private Deque deque;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new CacheNode();
        tail = new CacheNode();
        head.setNext(tail);
        tail.setPrev(head);
    }

    private void removeNode(CacheNode node)
    {
        CacheNode prev = node.getPrev();
        CacheNode next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
    }

    private void moveToHead(CacheNode node){
        node.setPrev(head);
        node.setNext(head.getNext());

        head.getNext().setPrev(node);
        head.setNext(node);
    }

    private void popTail()
    {
        CacheNode node = tail.getPrev();
        CacheNode pre = tail.getPrev().getPrev();
        if(pre == null)
            return;
        map.remove(node.getKey());
        pre.setNext(tail);
        tail.setPrev(pre);
    }

    public int get(int key)
    {
        if (map.get(key) != null)
        {
            CacheNode node = map.get(key);
            removeNode(node);
            moveToHead(node);
            return node.getValue();
        }
        return -1;
    }

    public void put(int key, int value)
    {
        if (map.get(key) == null)
        {
            CacheNode node = new CacheNode();
            node.setKey(key);
            node.setValue(value);
            moveToHead(node);
            map.put(key, node);
            if(count == capacity){
                popTail();
            }
            else{
                count++;
            }
        }
        else{
            CacheNode node = map.get(key);
            removeNode(node);
            moveToHead(node);
            node.setValue(value);
        }
    }
}
