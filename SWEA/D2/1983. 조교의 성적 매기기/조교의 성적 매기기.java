import java.io.*;
import java.util.*;

public class Solution {
    static List<Double> list, rawList;
    static Map<Double, String> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        String[] words = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            rawList = new ArrayList<>();
            map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int grade1 = Integer.parseInt(st.nextToken());
                int grade2 = Integer.parseInt(st.nextToken());
                int grade3 = Integer.parseInt(st.nextToken());

                double total = grade1 * 0.35  + grade2 * 0.45 + grade3 * 0.2;
                list.add(total);
                rawList.add(total);
            }
            double score = list.get(k - 1);
            list.sort(Comparator.reverseOrder());

            int rank = list.indexOf(score);
            int scoreIndex = rank * 10 / n;

            bw.write("#" + test_case + " " + words[scoreIndex] + "\n");

        }
        bw.flush();
        bw.close();
    }

}