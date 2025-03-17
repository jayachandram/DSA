class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        li = []
        for i in nums:
            if i not in li:
                li.append(i)
            else:
                li.remove(i)
        return len(li) == 0
