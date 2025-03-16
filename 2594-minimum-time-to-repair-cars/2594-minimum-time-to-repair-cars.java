class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 0;
        long right = 0;
        long ans = 0;
        for(int i : ranks)
            right = Math.max(right, i);

        right = right * cars * cars;

        while(left <= right)
        {
            long mid = (left + right)/2;
            if(isValid(mid, ranks, cars)){
                ans = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return ans;
    }
    private boolean isValid(long time, int[] ranks, long cars)
    {
        long currentCars = 0;
        for(int i : ranks)
        {
            currentCars += Math.sqrt(time/i);
        }
        return currentCars >= cars ? true : false;
    }
}