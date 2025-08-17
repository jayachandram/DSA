import java.util.*;

class Solution {
    public void rearrange(int[] arr, int x) {

        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> Math.abs(a - x) - Math.abs(b - x));

        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}
