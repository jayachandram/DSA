class Solution {
    public static int largest(int[] arr) {
        // code here
        int max  = -1;
        
        for(int i : arr)
            if(i > max)
                max = i;
                
        return max;
    }
}
