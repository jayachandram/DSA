from collections import Counter
class Solution:
    def minimumOperations(self, nums: List[int]) -> int:

        minOperations = 0
        boolean = False

        while True:
            boolean = False
            if(len(nums) < 2):
                return minOperations
            if(len(nums) == 2):
                if(nums[0] != nums[1]):
                    return minOperations
                minOperations += 1
                return minOperations
            if(len(nums) == 3):

                for i in range(3):
                    for j in range(3):
                        if i != j and nums[i] == nums[j]:
                            minOperations += 1
                            return minOperations
                return minOperations

            d = Counter(nums)

            for i in d:
                if d[i] > 1:
                    boolean = True
            
            if boolean:
                nums= nums[3:]
                minOperations += 1
            else:
                return minOperations
        
        return minOperations
