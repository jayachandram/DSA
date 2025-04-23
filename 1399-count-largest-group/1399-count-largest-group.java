class Solution {
    public int countLargestGroup(int n) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int max_size = 0;
        
        for(int i = 1; i <= n; i++)
        {
            int digit = sumOfDigits(i);

            map.put(digit, map.getOrDefault(digit,0) + 1);
            max_size = Math.max(max_size, map.get(digit));

        }

        int count = 0;

        for(int key : map.keySet())
        {
            if(map.get(key) == max_size)
                count++;
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