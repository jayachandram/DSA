class Solution {
    public int countTriples(int n) {

        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 1; i <= n; i++)
            set.add(i * i);
            
        for(int i = 1; i < n; i++)
            for(int j = i + 1; j < n; j++)
                if(set.contains(i * i + j * j))
                   ans++;
                    
        return ans * 2;
    }
}