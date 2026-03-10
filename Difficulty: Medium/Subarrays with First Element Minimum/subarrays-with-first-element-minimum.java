class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        
        Stack<Integer> stack = new Stack<>();
        int n = arr.length, ans = 0;
        
        for(int i = n-1; i >= 0; i--)
        {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            
            int last = stack.isEmpty() ? n : stack.peek();
            
            ans += (last - i);
            stack.push(i);
        }
        return ans;
    }
}
