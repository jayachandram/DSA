class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        
        // Step 1: Find the rightmost pair where nums[i] < nums[i + 1]
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        
        // If no such index is found, the array is in descending order, reverse it to get the smallest permutation
        if (index == -1) {
            // Reverse the entire array
            int start = 0, end = nums.length - 1;
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
            return;
        }
        
        // Step 2: Find the rightmost element greater than nums[index]
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                // Step 3: Swap nums[index] and nums[i]
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        
        // Step 4: Reverse the sequence from index + 1 to the end
        int start = index + 1, end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
