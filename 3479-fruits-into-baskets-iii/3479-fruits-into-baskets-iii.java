class Solution {
    private int[] segmentTree ;
    private int n;
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = fruits.length;
        segmentTree = new int[ 4 * n];
        build(baskets, 0, n - 1, 1);
        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            if(placed(fruits[i], 0, n -1, 1) == -1)
                ans++;
        }
        return ans;
    }
    private void build(int[] baskets, int low, int high, int index)
    {
        if(low == high)
        {
            segmentTree[index] = baskets[low];
        }
        else
        {
            int mid = low + (high - low) / 2;
            build(baskets, low, mid, 2 * index);
            build(baskets, mid + 1, high, 2 * index + 1);
            segmentTree[index] = Math.max(segmentTree[2  * index], segmentTree[2 * index + 1]);
        }
    }
    private int placed(int fruit, int low, int high, int index)
    {
        if(segmentTree[index] < fruit)
            return -1;

        if (low == high) {
            segmentTree[index] = -1;
            return 1;
        }
        int mid = low + (high - low) / 2;
        int res;
        if (segmentTree[2 * index] >= fruit) {
            res = placed(fruit, low, mid, 2 * index);
        } else {
            res = placed(fruit, mid + 1, high, 2 * index + 1);
        }
        segmentTree[index] = Math.max(segmentTree[2 * index], segmentTree[2 * index + 1]);
        return res;
    }
}