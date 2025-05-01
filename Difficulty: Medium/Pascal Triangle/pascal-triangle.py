#User function Template for python3
from math import comb
class Solution:
	def nthRowOfPascalTriangle(self, n):
	    return [comb(n-1,i) for i in range(n)]
#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':

    tc = int(input())
    while tc > 0:
        n = int(input())
        ob = Solution()
        ans = ob.nthRowOfPascalTriangle(n)
        for x in ans:
            print(x, end=" ")
        print()
        tc = tc - 1
        print("~")
# } Driver Code Ends