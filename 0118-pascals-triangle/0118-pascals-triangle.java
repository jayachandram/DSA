class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i <= numRows; i++)
        {
            List<Integer> currRow = new ArrayList<>();
            int start = 1;
            currRow.add(start);

            for(int j = 1; j < i; j++)
            {
                start = start * (i - j);
                start = start / j;
                currRow.add(start);
            }
            ans.add(currRow);
        }
        return ans;
    }
}