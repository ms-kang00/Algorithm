import java.io.*;
import java.util.*;

public class Solution
 {

     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int firstHour = Integer.parseInt(st.nextToken());
            int firstMinute = Integer.parseInt(st.nextToken());

            int secondHour = Integer.parseInt(st.nextToken());
            int secondMinute = Integer.parseInt(st.nextToken());

            int sumHour = firstHour + secondHour;
            if (sumHour > 12) {
                sumHour %= 12;
            }

            int sumMinute = firstMinute + secondMinute;

            if (sumMinute > 60) {
                sumMinute -= 60;
                sumHour += 1;
            }

            System.out.println("#" + test_case + " " + sumHour + " " + sumMinute);
        }
    }
}
