
class Solution:
    def countNumberswith4(self, n: int) -> int:
        cnt = 0
        for i in range(1, n + 1):
            if '4' in str(i):
                cnt += 1
        return cnt





#{ 
 # Driver Code Starts
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):

        n = int(input())

        obj = Solution()
        res = obj.countNumberswith4(n)

        print(res)

        print("~")
# } Driver Code Ends