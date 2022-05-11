import java.util.HashMap;
import java.util.Map;

class LRUCache {
    
	final Node head;
    final Node tail;
    Map<Integer, Node> lruCache;
    private final int CACHE_CAPACITY;
    
    public LRUCache(int capacity) {
        CACHE_CAPACITY = capacity;
        lruCache = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        int result = -1;
        Node node = lruCache.get(key);
    	if(node!=null) {
        	
        	remove(node);
        	add(node);
        	result = node.val;
        } 
    	return result;
    }
    
    public void put(int key, int value) {
    	Node node = lruCache.get(key);
    	if(node != null) {
    		remove(node);
    		node.val = value;
    		add(node);    		   		
    	} 
		if(lruCache.size() == CACHE_CAPACITY) {
			lruCache.remove(tail.prev.key);
			remove(tail.prev);   			
		}
		Node n = new Node(key, value);
		
		lruCache.put(key, n);
		add(n);
    	
    }
    
    private void add (Node node) {
        
        node.next = head.next;      
        head.next.prev = node;
        head.next = node;
        node.prev = head;
       
        
    }
    
    private void remove(Node node) {
    	Node node_prev = node.prev;
    	Node node_next = node.next;
    	node_prev.next = node_next;
    	node_next.prev = node_prev;
    }
    
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node (int key, int value){
        	this.key = key;
        	this.val = value;
        }
    }
    
    public static void main(String [] args) {
    	LRUCache cache = new LRUCache(2);
    	cache.put(1, 1);
    	cache.put(2, 2);
    	System.out.println(cache.get(1));
    	cache.put(3, 3);
    	System.out.println(cache.get(2));
    	cache.put(4, 4);
    	System.out.println(cache.get(1));
    	System.out.println(cache.get(3));
    	System.out.println(cache.get(4));
    }
}
