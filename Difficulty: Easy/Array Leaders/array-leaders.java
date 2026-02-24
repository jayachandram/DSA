class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int curr = arr[arr.length - 1];
        
        for(int i = arr.length - 1; i >= 0; i--)
        {
            if(arr[i] >= curr)
            {
                ans.add(arr[i]);
                curr = arr[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
