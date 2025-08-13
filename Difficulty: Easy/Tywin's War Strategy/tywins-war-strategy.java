class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
        int luckyNumbers = 0;
        int ans = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] % k == 0) luckyNumbers++;
            else minHeap.add(k - (arr[i] % k));
        }
        
        if(luckyNumbers >= Math.ceil((float)arr.length / 2.0)) return 0;
        
        while(luckyNumbers < Math.ceil((float)arr.length / 2.0))
        {
            ans += minHeap.remove();
            luckyNumbers++;
        }
        return ans;
    }
}