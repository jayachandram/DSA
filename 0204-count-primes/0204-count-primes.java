class Solution {
    public int countPrimes(int n) {

        if(n < 2)
            return 0;
        
        Boolean[] isPrimes = new Boolean[n];
        Arrays.fill(isPrimes, true);

        isPrimes[0] = isPrimes[1] = false;

        for(int i = 2; i * i < n; i++)
        {
            if(isPrimes[i])
            {
                for(int j = i * i; j < n; j = j + i)
                    isPrimes[j] = false;
            }
        }

        return (int)Arrays.stream(isPrimes).filter(x -> x == true).count();
    }
}