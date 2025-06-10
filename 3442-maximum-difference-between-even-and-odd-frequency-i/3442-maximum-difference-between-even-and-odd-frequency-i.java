class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for(char ch : s.toCharArray()) freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int val : freq.values())
        {
            if(val % 2 != 0) max = Math.max(max, val);
            else min = Math.min(min, val);
        }
        return max - min;
    }
}