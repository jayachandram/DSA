class Solution {
    public int getCount(int n, int d) {
        // code here
        int min = 1, max = n;
        int ans = 0;
        
        while(min <= max)
        {
            int mid = (min + max) / 2;
            int sum = 0;
            int temp = mid;
            
            while(temp > 0)
            {
                sum += temp % 10;
                temp = temp / 10;
            }
            if(mid - sum >= d)
            {
                max = mid - 1;
            }
            else
            {
                min = mid + 1;
            }
        }
        
        return n - min + 1;
    }
};