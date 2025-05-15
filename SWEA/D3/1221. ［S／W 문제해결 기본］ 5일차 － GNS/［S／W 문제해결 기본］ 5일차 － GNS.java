import java.io.*;
import java.util.*;

public class Solution {
    static String[] words = {"ZRO", "ONE", "TWO", "THR", "FOR",
            "FIV", "SIX", "SVN", "EGT", "NIN"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String tc = st.nextToken();
            int length = Integer.parseInt(st.nextToken());

            // 카운팅용 맵 초기화
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, 0);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < length; i++) {
                String token = st.nextToken();
                map.put(token, map.get(token) + 1);
            }

            bw.write(tc + "\n");
            for (String word : words) {
                int count = map.get(word);
                for (int i = 0; i < count; i++) {
                    bw.write(word + " ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}