class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length, m = nums2.length, size = 0, i = 0, j = 0, k = 0;;

        while(i < n && j < m)
        {
            if(nums1[i][0] == nums2[j][0])
            {
                size++;
                i++;
                j++;
            }
            else if(nums1[i][0] < nums2[j][0])
                i++;
            else
                j++;
        }

        int[][] ans = new int[n + m - size][2];
        i = 0;
        j = 0;
        while(i < n && j < m)
        {
            if(nums1[i][0] == nums2[j][0])
            {
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            }
            else if(nums1[i][0] < nums2[j][0])
            {
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1];
                i++;
            }
            else
            {
                ans[k][0] = nums2[j][0];
                ans[k][1] = nums2[j][1];
                j++;
            }
            k++;
        }
        while(i < n)
        {
            ans[k][0] = nums1[i][0];
            ans[k++][1] = nums1[i++][1];
        }
        while(j < m)
        {
            ans[k][0] = nums2[j][0];
            ans[k++][1] = nums2[j++][1];
        }

        return ans;
    }
}