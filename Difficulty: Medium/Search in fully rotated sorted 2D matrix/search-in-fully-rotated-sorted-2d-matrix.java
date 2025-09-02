class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        for(int i=0;i<mat.length ;i++){
            int left=0,right=mat[0].length-1;
            
            while(left<=right){
                int mid = left + (right-left)/2;
                
                if(mat[i][mid]==x) return true;
                if(mat[i][left]<mat[i][right] && x>mat[i][right]) break;
                
                if(mat[i][left]<mat[i][right]){
                    if(mat[i][mid]>x){
                        right = mid-1;
                    }else{
                        left = mid+1;
                    }
                }else{
                    //left part
                    if(mat[i][left]<=mat[i][mid]){
                        if(mat[i][mid]<x){
                            left = mid+1;
                        }else if(mat[i][left]<=x){
                            right = mid-1;
                        }else{
                            left = mid+1;
                        }
                    }else{
                        if(mat[i][mid]>x){
                            right = mid-1;
                        }else if(mat[i][right]>=x) {
                            left = mid+1;
                        }else{
                            right = mid-1;
                        }
                    }
                }
                
            }
            
        }
        return false;
}
}