class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int n = image.length, m = image[0].length;
        
        int[][] img = image;

            
        return f(img, image, sr, sc, newColor, image[sr][sc],  n, m);
        
    }
    private int[][] f(int[][] newImage, int[][] image, int sr, int sc, int newColor, int initialColor, int n, int m)
    {
        
        newImage[sr][sc] = newColor;
        
        int[] arr1 = {0, 0, -1, 1};
        int[] arr2 = {-1, 1, 0, 0};
            
        for(int i = 0; i < 4; i++)
        {
            int newRow = sr + arr1[i];
            int newCol = sc + arr2[i];
            
            if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && image[newRow][newCol] == initialColor && newImage[newRow][newCol] != newColor)
                f(newImage, image, newRow, newCol, newColor, initialColor, n, m);
        }
        return newImage;
    }
}