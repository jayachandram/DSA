class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int element1 = Integer.MAX_VALUE, element2 = Integer.MAX_VALUE, cnt1 = 0, cnt2 = 0;

        for(int element : nums)
        {
            if(element == element1) cnt1++;
            else if(element == element2) cnt2++;
            else if(cnt1 == 0)
            {
                element1 = element;
                cnt1++;
            }
            else if(cnt2 == 0)
            {
                element2 = element;
                cnt2++;
            }
            else
            {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;

        for(int num : nums)
        {
            if(num == element1) cnt1++;
            if(num == element2) cnt2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(cnt1 > nums.length / 3)
            ans.add(element1);
        if(cnt2 > nums.length / 3)
            ans.add(element2);

        return ans;
    }
}