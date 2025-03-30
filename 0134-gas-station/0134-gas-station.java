class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
         if(Arrays.stream(cost).sum() > Arrays.stream(gas).sum()) return -1;
        
        int total_cost = 0;
        int index = 0;
        
        for(int i = 0; i < gas.length; i++)
        {
            total_cost -= cost[i] - gas[i];
            
            if(total_cost < 0)
            {
                total_cost = 0;
                index = i + 1;
            }
            
        }
        return index;
    }
}