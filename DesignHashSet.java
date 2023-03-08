#https://leetcode.com/problems/design-hashset/description

class MyHashSet {
    private int primaryBucketSize;
    private int secondaryBucketSize;
    private boolean[][] bucket;

    public MyHashSet() {
        this.primaryBucketSize = 1000;
        this.secondaryBucketSize = 1000;
        this.bucket = new boolean[primaryBucketSize][];
    }
    
    public int primaryBucketHashKey(int key) {
        return key % primaryBucketSize;
    }

    public int secondaryBucketHashKey(int key) {
        return key / secondaryBucketSize;
    }

    public void add(int key) {
        int primaryHashKey = primaryBucketHashKey(key);
        int secondaryHashKey = secondaryBucketHashKey(key);

        if(bucket[primaryHashKey] == null) {
            if(primaryHashKey == 0) {
                bucket[primaryHashKey] = new boolean[secondaryBucketSize + 1];
            }
            else {
                bucket[primaryHashKey] = new boolean[secondaryBucketSize];
            }
        }

        bucket[primaryHashKey][secondaryHashKey] = true;    
    }
    
    public void remove(int key) {
        int primaryHashKey = primaryBucketHashKey(key);
        int secondaryHashKey = secondaryBucketHashKey(key);

        if(bucket[primaryHashKey] == null) return;
        
        bucket[primaryHashKey][secondaryHashKey] = false;
    }
    
    public boolean contains(int key) {
        int primaryHashKey = primaryBucketHashKey(key);
        int secondaryHashKey = secondaryBucketHashKey(key);

        if(bucket[primaryHashKey] == null) return false;

        return bucket[primaryHashKey][secondaryHashKey];
    }
}
