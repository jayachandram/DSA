class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack();
        stack.add(s.charAt(0));
        s = s.substring(1);
        for(char ch : s.toCharArray())
        {
            if(stack.isEmpty())
            {
                stack.add(ch);
                continue;
            }
            char c = stack.peek();
            if(c == ch)
                stack.pop();
            else
                stack.add(ch);
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty())
            ans.append(stack.pop());

        return ans.reverse().toString();
    }
}