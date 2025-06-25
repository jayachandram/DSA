class Solution {
    boolean sameFreq(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        // Count frequency of each character
        for (char ch : s.toCharArray())
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        // Count how many times each frequency occurs
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        for (int f : freq.values())
            freqCount.put(f, freqCount.getOrDefault(f, 0) + 1);

        // Case 1: all frequencies same
        if (freqCount.size() == 1)
            return true;

        // Case 2: two different frequencies
        if (freqCount.size() == 2) {
            Iterator<Map.Entry<Integer, Integer>> it = freqCount.entrySet().iterator();
            Map.Entry<Integer, Integer> e1 = it.next();
            Map.Entry<Integer, Integer> e2 = it.next();

            int f1 = e1.getKey(), c1 = e1.getValue();
            int f2 = e2.getKey(), c2 = e2.getValue();

            // One char occurs once and only once — can remove it
            if ((f1 == 1 && c1 == 1) || (f2 == 1 && c2 == 1))
                return true;

            // One frequency is higher by 1 and appears once — can reduce it
            if ((f1 - f2 == 1 && c1 == 1) || (f2 - f1 == 1 && c2 == 1))
                return true;
        }

        return false;
    }
}
