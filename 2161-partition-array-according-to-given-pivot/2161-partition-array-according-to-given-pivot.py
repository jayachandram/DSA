class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        cnt = 0
        l1, l2 = [], []
        for i in nums:
            if i == pivot:
                cnt += 1
            elif i < pivot:
                l1.append(i)
            else:
                l2.append(i)
        return l1 + list(pivot for _ in range(cnt)) +  l2