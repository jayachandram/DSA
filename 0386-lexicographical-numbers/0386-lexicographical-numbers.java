class Solution {
    public List<Integer> lexicalOrder(int n) {

        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i < 10; i++)
            dfs(i, n, ans);
        return ans;
    }
    private void dfs(int i, int n, List<Integer> ans)
    {
        if(i > n) return;
        ans.add(i);
        int curr = i * 10;
        for(int j = 0; j < 10; j++)
            if(curr + j <= n)
                dfs(curr + j, n, ans);
    }
}