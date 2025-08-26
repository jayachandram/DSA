class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        
        int maxArea = -1;
        double maxDiagonal = -1;

        for(int[] rectangle : dimensions)
        {
            int l = rectangle[0];
            int w = rectangle[1];
            double diagonal = Math.sqrt(l * l + w * w);
            if(diagonal > maxDiagonal)
            {
                maxArea = l * w;
                maxDiagonal = diagonal;
            }
            else if(diagonal == maxDiagonal) maxArea =  Math.max(maxArea, l * w);

        }
        return maxArea;
    }
}