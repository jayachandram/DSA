class Solution {
    public int longestStrChain(String words[]) {
        // code here
        
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        
        Map<String, Integer> dp = new HashMap<>();
        int maxChain = 1;
        
        for(String word : words)
        {
            dp.put(word,1);
            
            for(int i = 0; i < word.length(); i++)
            {
                String preString = word.substring(0,i) + word.substring(i+1);
    
                if(dp.containsKey(preString))
                    dp.put(word, Math.max(dp.get(word), dp.get(preString) + 1));
                
                maxChain = Math.max(maxChain, dp.get(word));
            }
        }
        
        return maxChain;
        
    }
}