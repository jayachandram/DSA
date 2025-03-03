class Solution {
    public int longestSubarray(int[] arr, int x) {
        Deque<Integer> minDq = new LinkedList<>();
        Deque<Integer> maxDq = new LinkedList<>();
        int currentIndex = 0, maxLength = 0, startIndex = 0;
        
        for(int i = 0; i < arr.length; i++)
        {
            while(!maxDq.isEmpty() && arr[maxDq.peekLast()] <= arr[i])
                maxDq.pollLast();
            maxDq.addLast(i);
            
            while(!minDq.isEmpty() && arr[minDq.peekLast()] >= arr[i])
                minDq.pollLast();
            minDq.addLast(i);
            
            
            while(arr[maxDq.peekFirst()] - arr[minDq.peekFirst()] > x)
            {
                currentIndex++;
                
                if(maxDq.peekFirst() < currentIndex)
                    maxDq.pollFirst();
 
                if(minDq.peekFirst() < currentIndex)
                    minDq.pollFirst();                   
            }
            
            if(i - currentIndex + 1 > maxLength)
            {
                maxLength =  i - currentIndex + 1;
                startIndex = currentIndex;
            }
        }
        return maxLength;
    }
}