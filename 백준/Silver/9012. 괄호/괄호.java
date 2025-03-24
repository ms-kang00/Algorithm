import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String line;
    static boolean isValid;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
    

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            Stack<Character> stack = new Stack<>();
            isValid = true;

            if (isBooleanValid(stack, line) == true) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }


        br.close();
        bw.flush();
        bw.close();
    }
    private static boolean isBooleanValid(Stack<Character> stack, String s) {
        for (char a : s.toCharArray()) {
            if (a == '(') {
                stack.push(a);
            } else {
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }
                stack.pop();
            }
        }
        
        if (isValid && stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
}
