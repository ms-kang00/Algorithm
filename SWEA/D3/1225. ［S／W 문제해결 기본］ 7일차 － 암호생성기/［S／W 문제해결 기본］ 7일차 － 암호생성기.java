import java.io.*;
import java.util.*;

public class Solution {
    static int[] arr;
    static Deque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int tc = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }

            int minus = 1;
            while (true) {
                int num = q.pollFirst() - minus;
                if (num <= 0) {
                    q.offerLast(0);
                    break;
                } else {
                    q.offerLast(num);
                }
                minus++;
                if (minus > 5) {
                    minus = 1;
                }
            }

            bw.write("#" + tc + " ");
            while (!q.isEmpty()) {
                bw.write(q.pollFirst() + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}