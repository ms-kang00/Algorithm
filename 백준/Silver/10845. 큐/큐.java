import java.io.*;
import java.util.*;

public class Main {
    
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("push")) {
                int a = Integer.parseInt(st.nextToken());
                queue.offer(a);
            } else if (s.equals("pop")) {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {

                    bw.write(queue.poll() + "\n");
                }
            } else if (s.equals("size")) {
                bw.write(queue.size() + "\n");
            } else if (s.equals("empty")) {
                if (queue.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if (s.equals("front")) {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.peek() + "\n");
                }
            } else if (s.equals("back")) {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {

                    int last = 0;
                    for (int a : queue) {
                        last = a;
                    }
                    bw.write(last + "\n");
                }
            }
        }
        
        
        
        
        br.close();
        bw.flush();
        bw.close();
    }
}
