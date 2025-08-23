


//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        if(arr.length < k)
            return -1;
        int low = 0 , high = 0, students = 0, pages = 0, mid;
        mid = (low + high)/2;
        for(int i : arr)
        {
            high += i;
            low = Math.max(low, i);
        }
        
        while(low <= high)
        {
            mid = (low + high)/2;
            
            students = 1;
            pages = 0;
            
            for(int i = 0; i < arr.length; i++)
            {
                if(pages + arr[i] <= mid)
                {
                    pages += arr[i];
                }
                else
                {
                    students++;
                    pages = arr[i];
                }
            }
            if(students > k)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return low;
    }
}