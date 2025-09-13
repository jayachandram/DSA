class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        // code here
                Arrays.sort(x);
        Arrays.sort(y); 

        int hCount = 1, vCount = 1; 
        int i = x.length - 1, j = y.length - 1; 
        int totalCost = 0;
        while (i >= 0 && j >= 0) {
            
            // Choose the larger cost cut to 
            // minimize future costs
            if (x[i] >= y[j]) {
                totalCost += x[i] * hCount; 
                vCount++;
                i--;
            } 
            else {
                totalCost += y[j] * vCount; 
                hCount++;
                j--;
            }
        }

        // Process remaining vertical cuts
        while (i >= 0) {
            totalCost += x[i] * hCount;
            vCount++;
            i--;
        }

        // Process remaining horizontal cuts
        while (j >= 0) {
            totalCost += y[j] * vCount;
            hCount++;
            j--;
        }

        return totalCost;
    }
}
