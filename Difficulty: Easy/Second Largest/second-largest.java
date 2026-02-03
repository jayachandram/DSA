class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int fLargest = -1, sLargest = -1;
        
        for(int num : arr) if(num > fLargest) fLargest = num;
        
        for(int num : arr) if(num > sLargest && num < fLargest) sLargest = num;
        
        return sLargest;
    }
}