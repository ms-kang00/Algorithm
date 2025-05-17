import java.io.*;
import java.util.*;

public class Solution {
    static Deque<Character> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            q = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            String num = st.nextToken();

            for (int i = 0; i < len; i++) {
                char c = num.charAt(i);
                if (!q.isEmpty() && q.peek() == c) {
                    q.pop();
                } else {
                    q.push(c);
                }
            }
            bw.write("#" + test_case + " ");
            Iterator<Character> it = q.descendingIterator();
            while (it.hasNext()) {
                bw.write(it.next());
            }
            bw.write("\n");

        }

        bw.flush();
        bw.close();
    }
}