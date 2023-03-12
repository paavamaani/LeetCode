https://leetcode.com/problems/group-anagrams

class Solution {
    public double hash(String string) {
        int primeNumbers[] = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        double hashKey = 1;

        for(int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);

            hashKey = hashKey * primeNumbers[character - 'a'];
        }

        return hashKey;
    }

    public List<List<String>> groupAnagrams(String[] strings) {
        if(strings == null || strings.length == 0) return new ArrayList<>();

        HashMap<Double, List<String>> anagrams = new HashMap<>();

        for(int i = 0; i < strings.length; i++) {
            String string = strings[i];
            double hashKey = hash(string);

            if(!(anagrams.containsKey(hashKey))) {
                anagrams.put(hashKey, new ArrayList<>());
            }
            
            anagrams.get(hashKey).add(string);
        }

        return new ArrayList<>(anagrams.values());
    }
}