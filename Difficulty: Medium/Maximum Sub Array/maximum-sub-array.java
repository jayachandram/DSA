class Solution {
    public ArrayList<Integer> findSubarray(int nums[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                long tempSum = temp.stream().mapToLong(Integer::longValue).sum();
                long ansSum = ans.stream().mapToLong(Integer::longValue).sum();
                
                if (!temp.isEmpty() && (tempSum > ansSum || (tempSum == ansSum && temp.size() > ans.size()))) {
                    ans = new ArrayList<>(temp);
                }
                temp = new ArrayList<>();
            } else {
                temp.add(nums[i]);
            }
        }
        
        long tempSum = temp.stream().mapToLong(Integer::longValue).sum();
        long ansSum = ans.stream().mapToLong(Integer::longValue).sum();
        
        if (!temp.isEmpty() && (tempSum > ansSum || (tempSum == ansSum && temp.size() > ans.size()))) {
            ans = new ArrayList<>(temp);
        }
        
        if (ans.isEmpty()) {
            ans.add(-1);
        }
               
        return ans;
    }
}