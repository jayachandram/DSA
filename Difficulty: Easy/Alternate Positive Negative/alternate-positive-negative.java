class Solution {
    void rearrange(ArrayList<Integer> arr) {

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Step 1: Separate while maintaining order
        for (int num : arr) {
            if (num >= 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }

        int i = 0, p = 0, n = 0;

        // Step 2: Alternate merge (start with positive)
        while (p < pos.size() && n < neg.size()) {
            arr.set(i++, pos.get(p++));
            arr.set(i++, neg.get(n++));
        }

        // Step 3: Append remaining positives
        while (p < pos.size()) {
            arr.set(i++, pos.get(p++));
        }

        // Step 4: Append remaining negatives
        while (n < neg.size()) {
            arr.set(i++, neg.get(n++));
        }
    }
}