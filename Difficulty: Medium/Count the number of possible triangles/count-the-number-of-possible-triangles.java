class Solution {
    public int countTriangles(int arr[]) {
        // code here
        Arrays.sort(arr);
        
        int ans = 0;
        
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i  + 1; j < arr.length; j++)
            {
                int l = j + 1, h = arr.length, target = arr[i] + arr[j], mid = 0;
                
                while(l < h)
                {
                    mid = (l + h) / 2;
                    if(arr[mid] >= target)
                    {
                        h = mid;
                    }
                    else
                    {
                        l = mid + 1;
                    }
                }
                ans += l - 1 - j;
            }
        }
        return ans;
    }
}