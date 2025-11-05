import java.io.*;
import java.util.*;

public class Solution {
    static Deque<String> deque;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int sideLength = N / 4;
            deque = new ArrayDeque<>();

            String input = br.readLine();
            for (int i = 0; i < input.length(); i++) {
                deque.offer(String.valueOf(input.charAt(i)));
            }

            // 순서 보장
            Set<Long> set = new TreeSet<>(Collections.reverseOrder());

            for (int i = 0; i < sideLength; i++) {
                Iterator<String> side = deque.iterator();
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < sideLength; k++) {
                        sb.append(side.next());
                    }
                    set.add(Long.parseLong(sb.toString(), 16));
                }
                deque.offerFirst(deque.pollLast());
            }

            Iterator<Long> iterator = set.iterator();
            long result = 0;

            for (int i = 0; i < K; i++) {
                if (iterator.hasNext()) {
                    result = iterator.next();
                } else {
                    break;
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
