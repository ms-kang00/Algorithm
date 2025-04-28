import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Comparator<Integer> comp = new Comparator<>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            int abs_o1 = Math.abs(o1);
            int abs_o2 = Math.abs(o2);

            if (abs_o1 == abs_o2) return o1 - o2;
            else return abs_o1 - abs_o2;
        }
    };
    static Queue<Integer> q = new PriorityQueue<>(comp);
    

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (q.isEmpty()) bw.write("0\n");
                else bw.write(q.poll() + "\n");
            } else {
                q.offer(x);
            }
        }

        
        bw.flush();
        bw.close();
    
    }

}
