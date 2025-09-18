class Solution {
    public ArrayList<Integer> nextGreater(int[] nums) {
        // code here
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1); // default: -1 if no greater found

        Stack<Integer> stack = new Stack<>();

        // Loop twice for circular effect
        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;

            // maintain strictly decreasing stack
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[index]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                res[index] = nums[stack.peek()];
            }

            stack.push(index);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int val : res) {
            result.add(val);
        }

        return result;
    }
}