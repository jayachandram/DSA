class Solution {
    public int minimumRecolors(String blocks, int k) {
        int w = 0;
        int ans = 0;

        for(int i = 0; i < k; i++)
            if(blocks.charAt(i) == 'W')
               w += 1;

        ans = w;
        int j = 0;

        for(int i = k; i < blocks.length(); i++)
        {
            if(blocks.charAt(i) == 'W')
                w += 1;

            if(blocks.charAt(j) == 'W')
                w = w > 0 ? w - 1 :  0;
            j++;
            ans = Math.min(ans, w);
        }
        return ans;
    }
}