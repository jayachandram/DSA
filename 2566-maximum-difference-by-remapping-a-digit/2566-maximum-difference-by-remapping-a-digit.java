class Solution {
    public int minMaxDifference(int num) {

        int n = (int) (Math.log10(num) + 1);

        int[] max_array = new int[n];
        int[] min_array = new int[n];

        int ii = n - 1;
        while(num > 0)
        {
            int digit = num % 10;
            max_array[ii] = digit;
            min_array[ii] = digit;
            num = num / 10;
            ii--;
        }

        int min_number = Integer.MAX_VALUE, max_number = -1;

        for(int i = 0; i < n; i++)
        {
            if(max_number == -1 && max_array[i] != 9)
            {
                max_number = max_array[i];
                break;
            }
        }

        for(int i = n - 1; i >= 0; i--)
        {
            if(min_array[i] != 0)
            {
                min_number = min_array[i];
            }
        }
        for(int i = 0; i < n; i++)
        {
            if(min_array[i] == min_number) min_array[i] = 0;
            if(max_array[i] == max_number) max_array[i] = 9;
        }

        int num1 = 0, num2 = 0;
        for(int i = 0; i < n; i++)
        {
           num1 = num1 * 10 + max_array[i];
           num2 = num2 * 10 + min_array[i];
        }

        return num1 - num2;
            

    }
}