class Solution {
    public String countAndSay(int n) {

        if(n == 1)
            return "1";

        StringBuilder previous = new StringBuilder("1");

        for(int i = 1; i < n; i++)
        {
            StringBuilder current = new StringBuilder();
            for(int j = 0; j < previous.length(); )
            {
                int count = 0;
                char c = previous.charAt(j);
                int k = j;

                while(k < previous.length() && previous.charAt(k) == c)
                {
                    count++;
                    k++;
                }

                current.append(count);
                current.append(c);
                j = k;
            }
            previous = current;
        }
        return previous.toString();
    }
}
