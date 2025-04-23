class Solution {
    public int countLargestGroup(int n) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int max_size = 0;
        int count = 0;

        for(int i = 1; i <= n; i++)
        {
            int digit = sumOfDigits(i);

            map.put(digit, map.getOrDefault(digit,0) + 1);

            if(max_size < map.get(digit))
            {
                max_size = map.get(digit);
                count = 1;
            }
            else if(max_size == map.get(digit))
            {
                count++;
            }
        }

        return count;
    }

    private int sumOfDigits(int num)
    {
        int sum = 0;

        while(num > 0)
        {
            sum += num % 10;
            num /= 10;
        }
        
        return sum;
    }
}