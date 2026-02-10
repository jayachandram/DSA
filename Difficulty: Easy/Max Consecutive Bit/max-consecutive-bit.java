class Solution {
    public int maxConsecBits(int[] nums) {
        // code here
        int max1= 0, max2 = 0, curr1 = 0, curr2 = 0;

        for(int num : nums)
        {
            if(num == 1)
            {
                curr1++;
                max2 = Math.max(max2, curr2);
                curr2 = 0;
                
            }
            else
            {
                curr2++;
                max1 = Math.max(max1, curr1);
                curr1 = 0;
            }
        }
        max2 = Math.max(max2, curr2);
        max1 = Math.max(max1, curr1);
        return max1 > max2 ? max1 : max2;

    }
}