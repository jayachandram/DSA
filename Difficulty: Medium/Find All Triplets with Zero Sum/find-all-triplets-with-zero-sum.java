// User function Template for Java
class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
     Set<List<Integer>> ansSet = new HashSet();
        Map<Integer, List<int[]>> mp =new HashMap();
        
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int sum = arr[i]+arr[j];
                if(!mp.containsKey(sum))
                {
                    mp.put(sum, new ArrayList<>());
                }
                mp.get(sum).add(new int[]{i,j});
            }
        }
        
        for(int i=0;i<arr.length;i++){
            int tar = -arr[i];
            if(mp.containsKey(tar)){
                List<int[]> pairs = mp.get(tar);
                for(int[] pair: pairs){
                    if(pair[0]!=i && pair[1]!=i){
                        List<Integer> curr = Arrays.asList(i, pair[0], pair[1]);
                        Collections.sort(curr);
                        ansSet.add(curr);
                    }
                }
            }
        }
        return new ArrayList<>(ansSet);
    }
}
