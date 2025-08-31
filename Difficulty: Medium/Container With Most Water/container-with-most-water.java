class Solution {
    public int maxWater(int arr[]) {
        // Code Here
        
        int left = 0, right = arr.length - 1, ans = 0;
        
        while(left < right)
        {
            int currentAnswer =  (right - left)* Math.min(arr[left], arr[right]);
            ans = Math.max(ans, currentAnswer);
            
            if(arr[left] <= arr[right]) left++;
            else right--;
        }
        return ans;
    }
}