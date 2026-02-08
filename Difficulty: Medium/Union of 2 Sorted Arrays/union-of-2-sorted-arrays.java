class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i = 0, j = 0;
        int n = a.length, m = b.length;

        while (i < n && j < m) {
            int val;
            if (a[i] < b[j]) {
                val = a[i++];
            } else if (a[i] > b[j]) {
                val = b[j++];
            } else {
                val = a[i];
                i++; 
                j++;
            }

            if (ans.isEmpty() || ans.get(ans.size() - 1) != val) {
                ans.add(val);
            }
        }

        while (i < n) {
            if (ans.isEmpty() || ans.get(ans.size() - 1) != a[i]) {
                ans.add(a[i]);
            }
            i++;
        }

        while (j < m) {
            if (ans.isEmpty() || ans.get(ans.size() - 1) != b[j]) {
                ans.add(b[j]);
            }
            j++;
        }

        return ans;
    }
}
