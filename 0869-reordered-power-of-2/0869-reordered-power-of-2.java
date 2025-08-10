class Solution {
    public boolean reorderedPowerOf2(int n) {
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            powers.add(1 << i); // 2^i
        }

        String numStr = String.valueOf(n);
        int len = numStr.length();
        int[] realCount = new int[10];

        // Count digits in n
        for (char c : numStr.toCharArray()) {
            realCount[c - '0']++;
        }

        for (int power : powers) {
            String powerStr = String.valueOf(power);
            if (powerStr.length() == len) {
                int[] checkCount = new int[10];
                for (char c : powerStr.toCharArray()) {
                    checkCount[c - '0']++;
                }
                if (Arrays.equals(realCount, checkCount)) {
                    return true;
                }
            }
        }
        return false;
    }
}
