//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S2 = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) image[i][j] = Integer.parseInt(S2[j]);
            }
            int sr = Integer.parseInt(br.readLine().trim());
            int sc = Integer.parseInt(br.readLine().trim());
            int newColor = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


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