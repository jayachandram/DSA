class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        
        for(int num : nums) freq[num]++;

        int cnt = 0, max = Arrays.stream(freq).max().getAsInt();

        for(int num : freq) if(num == max) cnt++;

        return cnt * max;

    }
}