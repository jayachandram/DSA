class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        for(int i = nums.length - 1; i > -1; i--)
        {
            heap.add(nums[i]);

            if(heap.size() > k)
                heap.poll();
        }
        return heap.peek();
    }
}