class Solution {
    public int longestConsecutive(int[] arr) {
        if(arr.length == 0)
            return 0;
        Arrays.sort(arr);
        int maxLength = 1;
        int count = 1;
        int min = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] == arr[i-1] + 1)
            {
                count++;
            }
            else if( arr[i] == arr[i-1])
            {
                continue;
            }
            else
            {
                count = 1;
            }
            maxLength = maxLength > count ? maxLength : count;
        }
        return maxLength;
    }
}