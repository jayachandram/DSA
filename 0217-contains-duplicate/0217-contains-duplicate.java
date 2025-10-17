class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> map = new HashSet<>();

        for(int num :  nums) map.add(num);

        return nums.length != map.size();
    }
}