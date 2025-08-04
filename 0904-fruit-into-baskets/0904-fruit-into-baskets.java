class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = 0;

        int i = 0;
        for(int j = 0; j < fruits.length; j++)
        {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            if(map.size() > 2)
            {
                if(map.get(fruits[i]) == 1) map.remove(fruits[i]);
                else map.put(fruits[i], map.get(fruits[i]) - 1);
                i++;
            }
            ans = Math.max(ans, j - i + 1);

        }
        return ans;
    }
}