class Solution:
    def longestSubsequence(self, s: str, k: int) -> int:
        
        count = 0
        val = 0
        power = 0

        for char in reversed(s):
            
            if(char == '0'): count += 1

            else:

                if(val + 2 ** power <= k):
                    val += 2 ** power
                    count += 1
                    
            power += 1

        return count