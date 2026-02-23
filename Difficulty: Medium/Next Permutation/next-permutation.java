class Solution {
    void nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        int idx = -1;
        
        for(int i = n - 2; i >= 0; i--)
        {
            if(arr[i] < arr[i + 1])
            {
                idx = i;
                break;
            }
        }
        
        if(idx == -1)
        {
            int start = 0, end = n -1;
            
            while(start < end)
            {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
            return;
        }
        for(int i = n - 1; i > idx; i--)
        {
            if(arr[idx] < arr[i])
            {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                break;
            }
        }
        int start = idx + 1, end = n -1;
            
            while(start < end)
            {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
    }
}