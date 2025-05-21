class Solution {
    public int findKthNumber(int m, int n, int k) {
        
        int start = 1, end = m * n;
        
        while(start <= end)
        {
            int mid = (start + end) / 2;
            
            if(count(mid, m, n) < k) start = mid + 1;
            
            else end = mid - 1;
            
        }
        
        return start;
    }
    private int count(int mid, int m, int n)
    {
        int cnt = 0;
        
        for(int i = 1; i <= m; i++) cnt += Math.min(mid / i, n);
        
        return cnt;
    }
}