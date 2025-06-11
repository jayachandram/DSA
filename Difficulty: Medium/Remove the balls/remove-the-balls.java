class Solution {
    public int findLength(int[] color, int[] radius) {
        // code here
        Stack<int[]> stack = new Stack();
        stack.add(new int[]{color[0], radius[0]});
        
        for(int i = 1; i < color.length; i++)
        {
            if(stack.isEmpty())
            {
                stack.add(new int[]{color[i], radius[i]});
                continue;
            }
            int[] top = stack.peek();
            if(top[0] == color[i] && top[1] == radius[i])
                stack.pop();
            else
                stack.add(new int[]{color[i], radius[i]});
        }
        return stack.size();
    }
}