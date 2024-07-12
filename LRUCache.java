import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LRUCache {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		  System.out.println("Enter the capacity of the LRU Cache:");
	      int capacity = sc.nextInt();
	      LRUCache lruCache = new LRUCache(capacity);
		boolean wish=true;
		while(wish) {
			System.out.println("Choose an operation:");
            System.out.println("1. Put (key, value)");
            System.out.println("2. Get (key)");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Enter key:");
                    int key = sc.nextInt();
                    System.out.println("Enter value:");
                    int value = sc.nextInt();
                    lruCache.put(key, value);
                    System.out.println("Inserted (" + key + ", " + value + ")");
                    break;
                case 2:
                    System.out.println("Enter key:");
                    key = sc.nextInt();
                    int result = lruCache.get(key);
                    if (result == -1) {
                        System.out.println("Key " + key + " not found.");
                    } else {
                        System.out.println("Value for key " + key + " is " + result);
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        
		}
	}
	 class Node {
	        int key;
	        int value;
	        Node prev;
	        Node next;
	        
	        Node(int key, int value) {
	            this.key = key;
	            this.value = value;
	        }
	    }
	    
	    private Map<Integer, Node> cache;
	    private int capacity;
	    private Node head;
	    private Node tail;
	    
	    public LRUCache(int capacity) {
	        this.cache = new HashMap<>();
	        this.capacity = capacity;
	        this.head = new Node(-1, -1); // dummy head
	        this.tail = new Node(-1, -1); // dummy tail
	        this.head.next = this.tail;
	        this.tail.prev = this.head;
	    }
	    
	    public int get(int key) {
	        if (!cache.containsKey(key)) {
	            return -1;
	        }
	        
	        Node node = cache.get(key);
	        // Move accessed node to the front (most recently used)
	        moveToHead(node);
	        return node.value;
	    }
	    
	    public void put(int key, int value) {
	        if (cache.containsKey(key)) {
	            Node node = cache.get(key);
	            node.value = value; // update value
	            moveToHead(node); // move to front
	        } else {
	            Node newNode = new Node(key, value);
	            cache.put(key, newNode);
	            addNode(newNode); // add to front
	            
	            if (cache.size() > capacity) {
	                // Remove the least recently used node (from tail)
	                Node toRemove = tail.prev;
	                removeNode(toRemove);
	                cache.remove(toRemove.key);
	            }
	        }
	    }
	    
	    // Helper method to move node to the front (most recently used)
	    private void moveToHead(Node node) {
	        removeNode(node);
	        addNode(node);
	    }
	    
	    // Helper method to add node to the front
	    private void addNode(Node node) {
	        node.next = head.next;
	        node.prev = head;
	        head.next.prev = node;
	        head.next = node;
	    }
	    
	    // Helper method to remove node from the list
	    private void removeNode(Node node) {
	        node.prev.next = node.next;
	        node.next.prev = node.prev;
	    }
}
