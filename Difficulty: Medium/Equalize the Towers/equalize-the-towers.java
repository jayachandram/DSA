class Solution {
    public int minCost(int[] heights, int[] cost) {
        // code here
        int n = heights.length;
        int min = Arrays.stream(heights).min().getAsInt();
        int max = Arrays.stream(heights).max().getAsInt();
        int ans = 0;
        
        while(min <= max)
        {
            int mid = (min + max) / 2;
            
            int val1 = findCost(heights, cost, mid - 1);
            int val2 = findCost(heights, cost, mid);
            int val3 = findCost(heights, cost, mid + 1);
            
            if (val2 <= val1 && val2 <= val3)
            {
                ans = val2;
                break;
            }
            else if (val1 >= val2 && val2 >= val3) min = mid + 1;
            
    
            else if (val2 >= val1 && val3 >= val2) max = mid - 1;
            
        }
        return ans;
    }
    private int findCost(int[] heights, int[] cost, int mid)
    {
        int ans = 0;
        
        for(int i = 0; i < cost.length; i++)
        {
            ans += Math.abs(heights[i] - mid) * cost[i];
        }
        return ans;
    }
}
