class Solution {
    public String countAndSay(int n) {

        if(n == 1)
            return "1";

        StringBuilder previous = new StringBuilder("1");

        for(int i = 1; i < n; i++)
        {
            StringBuilder current = new StringBuilder();
            char ch = previous.charAt(0);
            int count = 0;
            for(int j = 0; j < previous.length();j++)
            {
                if(ch == previous.charAt(j))
                {
                    count++;
                }
                else
                {
                    current.append(String.valueOf(count));
                    current.append(ch);
                    ch = previous.charAt(j);
                    count = 1;
                }
            }
            current.append(String.valueOf(count));
            current.append(ch);
            previous = current;
        }
        return previous.toString();
    }
}
