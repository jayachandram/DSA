class Solution {
    public String clearStars(String s) {
        ArrayList<Stack<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 26; i++)
            list.add(new Stack<>());

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*') {
                list.get(arr[i] - 'a').push(i);
            } else {
                int targetIndex = -1;

                // Check all characters from 'a' to 'z'
                for (int j = 0; j < 26; j++) {
                    while (!list.get(j).isEmpty() && list.get(j).peek() > i) {
                        // Remove invalid indices (future characters)
                        list.get(j).pop();
                    }

                    if (!list.get(j).isEmpty()) {
                        targetIndex = list.get(j).pop();
                        break;
                    }
                }

                // Mark current '*' and the removed char (if found)
                if (targetIndex != -1)
                    arr[targetIndex] = '*';
                arr[i] = '*';
            }
        }

        // Build result string excluding all '*'
        StringBuilder ans = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}
