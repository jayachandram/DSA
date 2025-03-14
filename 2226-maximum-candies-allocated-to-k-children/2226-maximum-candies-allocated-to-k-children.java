class Solution {
    public int maximumCandies(int[] candies, long k) {
        long left = 1;
        long right = 0;
        long ans = 0;
        for(int i : candies)
            right += i;

        if(right < k)
            return 0;

        right /= k;
        while(left <= right)
        {
            long mid = (left + right)/2;
            if(isValid(mid, candies, k)){
                ans = mid;
                left = mid+1;
            }
            else
                right = mid - 1;
            
        }
        return (int)ans;
    }
    private boolean isValid(long num, int[] candies, long k)
    {
        long count = 0;
        for(int i : candies)
            count += i / num;
        return count >= k;
    }
}