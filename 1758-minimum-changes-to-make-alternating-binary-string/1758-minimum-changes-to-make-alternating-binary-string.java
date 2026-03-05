class Solution {
    public int minOperations(String s) {
        
        int[] arr1 = new int[s.length()];
        int[] arr2 = new int[s.length()];
        int ans1 = 0, ans2 = 0;

        for(int i = 0; i < arr1.length; i = i + 2) arr1[i] = 1;
        for(int i = 1; i < arr2.length; i = i + 2) arr2[i] = 1;

        for(int i = 0; i < arr1.length; i++)
            if(arr1[i] != s.charAt(i) - '0') ans1++;
        
        for(int i = 0; i < arr2.length; i++)
            if(arr2[i] != s.charAt(i) - '0') ans2++;
       

        return ans1 < ans2 ? ans1 : ans2;
    }
}