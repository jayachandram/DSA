class Solution {
    public boolean checkOnesSegment(String s) {
        
        int cnt = 0;
        boolean flag = false;
        int i;

        for(i = 0; i < s.length(); i++)
        {
          if(s.charAt(i) == '1')
          {
            flag = false;
            continue;
          }
          if(!flag) cnt++;

          if(s.charAt(i - 1) == '1')
          {
            flag = true;
          }
          
        }
        if(!flag) cnt++;
        return cnt == 1;
        
    }
}