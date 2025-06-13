class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        
        int min = 1, max = Arrays.stream(arr).max().getAsInt();
        int min_hours = Integer.MAX_VALUE;
        
        while(min <= max)
        {
            int mid = (min + max) / 2;
            
            int count = 0;
            for(int num : arr)
                count += (int)Math.ceil((float)num / (float)mid);
                
            if(count <= k) max = mid - 1;
            else min = mid + 1;

        }
        return min;
    }
}