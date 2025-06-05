class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] disjoint_set = new int[26];
        Arrays.fill(disjoint_set, -1);

        for(int i = 0; i < s1.length(); i++)
        {
            if(s1.charAt(i) == s2.charAt(i)) continue;
            int px = find(disjoint_set, s1.charAt(i) - 'a');
            int py = find(disjoint_set, s2.charAt(i) - 'a');
            if(px == py) continue;
            if(px > py) disjoint_set[px] = py;
            else disjoint_set[py] = px;
        } 
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < baseStr.length(); ++i) {
            int parent = find(disjoint_set, baseStr.charAt(i) - 'a');
            res.append((char) (parent + 'a'));
        }
        return res.toString();
    }
    int find(int[] disjoint_set, int pos)
    {
        if(disjoint_set[pos] == -1) return pos;
        return disjoint_set[pos] = find(disjoint_set, disjoint_set[pos]);
    }
}