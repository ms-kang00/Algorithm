import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Queue<Integer> q = new PriorityQueue<>();
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (q.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(q.poll() + "\n");
                }
            } else {
                q.add(x);
            }
        }
        

        bw.flush();
        bw.close();
    }

}
