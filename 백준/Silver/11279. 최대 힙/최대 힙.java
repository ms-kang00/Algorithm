import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            
            if (m == 0) {
                if (q.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(q.poll() + "\n");
                }
            } else {
                q.offer(m);
            }
        }

        bw.flush();
        bw.close();
    
    }

}
