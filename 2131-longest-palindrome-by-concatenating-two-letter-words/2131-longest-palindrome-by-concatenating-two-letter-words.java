class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;
        int center = 0;

        for (String s : words)
            map.put(s, map.getOrDefault(s, 0) + 1);

        
        for (String str : new HashSet<>(map.keySet())) {
            String rev = new StringBuilder(str).reverse().toString();

            if (!str.equals(rev) && map.containsKey(rev)) {
                int pairs = Math.min(map.get(str), map.get(rev));
                ans += pairs * 4;
                map.remove(str);
                map.remove(rev);
            } else if (str.equals(rev)) {
                int count = map.get(str);
                int pairs = count / 2;
                ans += pairs * 4;
                if (count % 2 == 1)
                    center = 1;
                map.remove(str);
            }
        }

        if (center == 1)
            ans += 2;

        return ans;
    }
}
