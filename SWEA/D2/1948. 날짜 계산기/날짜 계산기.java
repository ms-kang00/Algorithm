import java.io.*;
import java.util.*;

public class Solution
 {
     static int[] monthOfDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int firstMonth = Integer.parseInt(st.nextToken());
            int firstDay = Integer.parseInt(st.nextToken());

            int secondMonth = Integer.parseInt(st.nextToken());
            int secondDay = Integer.parseInt(st.nextToken());

            int result = 0;




            if (firstMonth != secondMonth) {
                result = monthOfDay[firstMonth - 1] - firstDay + secondDay + 1;

                for (int i = firstMonth; i < secondMonth - 1; i++) {
                    result += monthOfDay[i];
                }
            } else {
                result = secondDay - firstDay + 1;
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
