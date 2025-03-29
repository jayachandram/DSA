//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
      
        int n = profit.length;
        Integer[][] jobs = new Integer[n][2];
        
        for (int i = 0; i < n; i++) {
            jobs[i][0] = profit[i];
            jobs[i][1] = deadline[i];
        }
        
        Arrays.sort(jobs, new Comparator<Integer[]>() {
            public int compare(Integer[] a, Integer[] b) {
                return b[0].compareTo(a[0]);
            }
        });
        
        int maxDeadline = Arrays.stream(deadline).max().getAsInt();
        int[] slots = new int[maxDeadline];
        Arrays.fill(slots, -1);
        
        int jobCount = 0;
        int totalProfit = 0;
        
        for (Integer[] job : jobs) {
            int p = job[0];
            int d = job[1];
            
            for (int slot = Math.min(d, maxDeadline) - 1; slot >= 0; slot--) {
                if (slots[slot] == -1) {
                    slots[slot] = p;
                    jobCount++;
                    totalProfit += p;
                    break;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(jobCount);
        ans.add(totalProfit);
        
        return ans;
    }
}

//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] deadlineInput = sc.nextLine().trim().split("\\s+");
            int[] deadline =
                Arrays.stream(deadlineInput).mapToInt(Integer::parseInt).toArray();

            String[] profitInput = sc.nextLine().trim().split("\\s+");
            int[] profit =
                Arrays.stream(profitInput).mapToInt(Integer::parseInt).toArray();
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.jobSequencing(deadline, profit);
            System.out.println(result.get(0) + " " + result.get(1));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends