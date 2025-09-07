class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int left = 0, right = n -1;

        while(left <= right)
        {
            if(left == right) 
            {
                ans[left] = 0;
                return ans;

            }
            ans[left] = left + 1;
            ans[right] = -left-1;
            left++;
            right--;
        }
        return ans;
    }
}