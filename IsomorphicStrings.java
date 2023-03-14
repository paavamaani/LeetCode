#https://leetcode.com/problems/isomorphic-strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int len = s.length();
        HashMap<Character, Character> keyValues = new HashMap<>();
        HashSet<Character> values = new HashSet<>();

        for(int i = 0; i < len; i++) {
            Character keyValuesChar = s.charAt(i);
            Character valuesChar = t.charAt(i);

            if(keyValues.containsKey(keyValuesChar)) {
                if(!(keyValues.get(keyValuesChar) == valuesChar)) {
                    return false;
                }
            }
            else {
                if(!(values.contains(valuesChar))) {
                    values.add(valuesChar);
                    keyValues.put(keyValuesChar, valuesChar);
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }
}