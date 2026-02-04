class Solution:
    def removeDuplicates(self, arr):
        # code here 
        return sorted(list(set(arr)))