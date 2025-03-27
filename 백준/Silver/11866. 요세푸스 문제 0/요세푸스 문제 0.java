import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> dq = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            dq.offerLast(i);
        }

        sb.append("<");

        while (!dq.isEmpty()) {
            for (int i = 1; i < M; i++) {
                dq.offerLast(dq.pollFirst());
            }
            sb.append(dq.pollFirst());

            if (!dq.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");

        bw.write(sb + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
