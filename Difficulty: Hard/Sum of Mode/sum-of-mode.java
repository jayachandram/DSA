class Solution {
    public int sumOfModes(int[] arr, int k) {
        // code here
         int n = arr.length;
        int sum = 0;

        // Frequency map of elements in current window
        Map<Integer, Integer> mp = new HashMap<>();

        // TreeSet to maintain (frequency, -value) order
        TreeSet<int[]> st = new TreeSet<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]); // higher freq comes last
                }
                return Integer.compare(a[1], b[1]); // if tie, smaller element wins
            }
        });

        // Build initial window
        for (int i = 0; i < k; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        // Add to TreeSet
        for (Map.Entry<Integer, Integer> x : mp.entrySet()) {
            st.add(new int[]{x.getValue(), -x.getKey()});
        }

        // Add first mode
        sum += -st.last()[1];

        // Slide the window
        for (int i = k; i < n; i++) {
            int out = arr[i - k]; // element going out
            int in = arr[i];      // element coming in

            // Remove old frequency of outgoing element
            int outFreq = mp.get(out);
            st.remove(new int[]{outFreq, -out});
            mp.put(out, outFreq - 1);

            if (mp.get(out) > 0) {
                st.add(new int[]{mp.get(out), -out});
            } else {
                mp.remove(out);
            }

            // Update frequency of incoming element
            mp.put(in, mp.getOrDefault(in, 0) + 1);
            st.add(new int[]{mp.get(in), -in});

            // Add current mode
            sum += -st.last()[1];
        }

        return sum;
    }
}