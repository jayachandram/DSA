class Solution {
    public static int sumSubstrings(String s) {
        // code here
        int ans = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int num = 0;
            for(int j = i; j < s.length(); j++)
            {
                num = num * 10 + (s.charAt(j) - 48);
                ans += num;
            }
            //ans += num;
        }
        return ans;
    }
}