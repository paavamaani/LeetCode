https://leetcode.com/problems/design-hashmap/description

class MyHashMap {
    class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hashMapSize;
    private Node[] hashMap;

    public MyHashMap() {
        hashMapSize = 10000;
        hashMap = new Node[this.hashMapSize];
    }
    
    public int hash(int key) {
        return key % hashMapSize;
    }

    public Node findNode(Node head, int key) {
        Node current = head;
        Node previous = null;

        while(current != null && current.key != key) {
            previous = current;
            current = current.next;
        }

        return previous;
    }

    public void put(int key, int value) {
        int hashKey = hash(key);

        if(hashMap[hashKey] == null) hashMap[hashKey] = new Node(-1, -1);
        
        Node previous = findNode(hashMap[hashKey], key);
        
        if(previous.next == null) {
            previous.next = new Node(key, value);
        }
        else {
            previous.next.value = value;
        }
    }
    
    public int get(int key) {
        int hashKey = hash(key);

        if(hashMap[hashKey] == null) return -1;

        Node previous = findNode(hashMap[hashKey], key);

        if(previous.next == null) return -1;
        
        return previous.next.value;
    }
    
    public void remove(int key) {
        int hashKey = hash(key);
        
        if(hashMap[hashKey] == null) return;

        Node previous = findNode(hashMap[hashKey], key);
        
        if(previous.next == null) return;

        previous.next = previous.next.next;
    }
}