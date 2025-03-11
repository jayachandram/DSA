class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', -1);
        map.put('b',-1);
        map.put('c', -1);
        int count = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == 'a')
                map.put('a', i);
            if(s.charAt(i) == 'b')
                map.put('b', i);
            if(s.charAt(i) == 'c')
                map.put('c', i);
            if(map.get('a') != -1 && map.get('b') != -1 && map.get('c') != -1)
            {
                count += Math.min(map.get('a'), Math.min(map.get('b'), map.get('c'))) + 1;
            }
        }
        return count;
    }
}