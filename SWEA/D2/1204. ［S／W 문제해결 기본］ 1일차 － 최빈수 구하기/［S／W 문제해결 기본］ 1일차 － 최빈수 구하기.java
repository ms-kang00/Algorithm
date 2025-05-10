import java.io.*;
import java.util.*;

public class Solution
{
    static int[] scores;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int num = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            scores = new int[1001];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
                map.put(scores[i], map.getOrDefault(scores[i], 0) + 1);
            }

            int key = 0;
            int max = 0;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > max ||
                        entry.getValue() == max &&
                                entry.getKey() > key) {
                    max = entry.getValue();
                    key = entry.getKey();
                }
            }
            bw.write("#" + test_case + " " + key + "\n");
        }
        bw.flush();
        bw.close();
    }

}