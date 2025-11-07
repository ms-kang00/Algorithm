import java.io.*;
import java.util.*;

public class Solution {
    static int[] week;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            week = new int[7];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 7; i++) {
                week[i] = Integer.parseInt(st.nextToken());
            }


            int minDay = Integer.MAX_VALUE;

            for (int i = 0; i < 7; i++) {
                if (week[i] == 0) continue;

                int dayCount = 0;
                int totalDay = 0;
                int currentDay = i;

                while (true) {
                    if (dayCount == N) {
                        break;
                    }

                    if (week[currentDay % 7] == 1) {
                        dayCount++;
                    }
                    totalDay++;
                    currentDay++;

                }

                minDay = Math.min(minDay, totalDay);
            }

            System.out.println("#" + test_case + " " + minDay);
        }
    }
}
