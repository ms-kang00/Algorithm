import java.io.*;
import java.util.*;

public class Main {
    
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("push")) {
                int a = Integer.parseInt(st.nextToken());
                stack.push(a);
            } else if (s.equals("top")) {
                bw.write(stack.isEmpty() ? "-1\n" : stack.peek() + "\n");
            } else if (s.equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (s.equals("empty")) {
                if (stack.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if (s.equals("pop")) {
                if (stack.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(stack.pop() + "\n");
                }
            }
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}
