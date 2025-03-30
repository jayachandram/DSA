class Solution {
    public List<Integer> partitionLabels(String s) {

        HashMap<Character, int[]> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(char c : s.toCharArray())
            map.put(c,new int[]{-1,-1});
        

        for(int i = 0; i < s.length(); i++)
        {
            int[] arr = map.get(s.charAt(i));
            if(arr[0] == -1)
            {
                arr[0] = i;
                arr[1] = i;
            }
            else
                arr[1] = i;   
        }
        int size = 0, end = 0;

        for(int i = 0; i < s.length(); i++)
        {
            int[] val = map.get(s.charAt(i));

            end = Math.max(end, val[1]);

            size++;

            if(i == end)
            {
                ans.add(size);
                size = 0;
            }
        }
        return ans;
    }
}