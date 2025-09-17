import java.util.*;

class Solution {
    static String decodeString(String s) {
        if (s == null || s.length() == 0) return "";

        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');               // build multi-digit number
            } else if (ch == '[') {
                numStack.push(num);                        // save the current number
                strStack.push(curr.toString());            // save the current built string
                curr = new StringBuilder();                // reset current
                num = 0;
            } else if (ch == ']') {
                int repeat = numStack.isEmpty() ? 1 : numStack.pop();
                String prev = strStack.isEmpty() ? "" : strStack.pop();

                StringBuilder tmp = new StringBuilder(prev);
                for (int k = 0; k < repeat; k++) tmp.append(curr);
                curr = tmp;
            } else {
                curr.append(ch);                           // normal character
            }
        }

        return curr.toString();
    }
}
