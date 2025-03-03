class Solution {
    public int[] pivotArray(int[] arr, int pivot) {

        int n = arr.length;
        int[] ans = new int[n];
        int i = 0, j = n - 1, l = 0, r = n - 1;

        for(i = 0; i < n && j > -1; i++, j--)
        {
            if(arr[i] < pivot)
                ans[l++] = arr[i];

            if(arr[j] > pivot)
                ans[r--] = arr[j];
        }
        for(i = l; i <= r; i++)
            ans[i] = pivot;
        return ans;
    }
}