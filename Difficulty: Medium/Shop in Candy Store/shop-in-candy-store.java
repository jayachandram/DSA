class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(prices);
        
        int left = 0, right = prices.length - 1, min = 0, max = 0;
        
        while(left <= right)
        {
            min += prices[left];
            right = right - k;
            left++;
        }
        left = 0;
        right = prices.length - 1;
        while(left <= right)
        {
            max += prices[right];
            left = left + k;
            right--;
        }
        ans.add(min);
        ans.add(max);
        
        return ans;
    }
}
