// User function Template for Java

class Solution {
    int countSubstr(String s, int k) {
        // your code here
        return f(s, k) - f(s, k - 1);
    }
    private int f(String s, int k)
    {
        int[] map = new int[26];
        int ans = 0;
        int i = 0;
        int distinct = 0;
        for(int j = 0; j < s.length(); j++)
        {
            if(map[s.charAt(j) - 'a'] == 0)
                distinct += 1;
            map[s.charAt(j) - 'a']++;

            while(distinct > k)
            {
                if(map[s.charAt(i) - 'a'] == 1)
                    distinct--;
                map[s.charAt(i) - 'a']--;
                i++;
            }
            ans += j - i + 1;
        }
        return ans;
    }
}