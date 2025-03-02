class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int[] ans = new int[arr.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        
        for(int i = 0; i < arr.length; i++)
        {
            if(!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();
                
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i])
                dq.pollLast();
            
            dq.addLast(i);
            
            if(i >= k - 1)
                ans[i - k + 1] = arr[dq.peekFirst()];
        }
        return ans;
    }
}