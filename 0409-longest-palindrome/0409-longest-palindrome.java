class Solution {
    public int longestPalindrome(String s) {

        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0;
        boolean bool = false;
        for(char ch : s.toCharArray())
            map.put(ch, (map.getOrDefault(ch, 0) + 1));
        
        for(char ch : map.keySet())
        {
            if(map.get(ch) % 2 == 0)
                ans += map.get(ch);
            else if(map.get(ch) > 2)
                ans += map.get(ch) - 1;
            if(map.get(ch) % 2 != 0)
                bool = true;
        }
        return bool ? ans + 1 : ans;

    }
}