class FindSumPairs {
    int[] nums1;
    int[] nums2;
    HashMap<Integer, Integer> map;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map = new HashMap<>();
        for(int num : nums2)
            map.put(num, map.getOrDefault(num, 0) + 1);
    }
    
    public void add(int index, int val) {
        int curr = nums2[index];
        nums2[index] += val;
        map.put(curr, map.get(curr) - 1);
        map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
        if(map.get(curr) == 0) map.remove(curr);
    }
    
    public int count(int tot) {
        int cnt = 0;
        for(int i = 0; i < nums1.length; i++)
            if(map.containsKey(tot - nums1[i]))
                cnt += map.get(tot - nums1[i]);
        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */