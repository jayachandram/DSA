class Solution {
    int maxSum(int[] arr) {
        // code here
        int ans = 0, currentValue = 0,arrSum = 0;
        
        for(int i = 0; i < arr.length; i++)
        {
            arrSum += arr[i];
            currentValue += i * arr[i];
        }
        ans = currentValue;
        
        for(int i = 1; i < arr.length; i++)
        {
            currentValue += arrSum -(arr.length * arr[arr.length - i]);
            ans = Math.max(ans, currentValue);
        }
        return ans;
    }
}