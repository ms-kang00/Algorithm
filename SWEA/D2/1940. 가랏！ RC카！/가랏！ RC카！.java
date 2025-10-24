import java.io.*;
import java.util.*;

public class Solution
 {

     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] preSpeed = new int[N+1];

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                int speed = 0;

                if (type == 1 || type == 2) {
                    speed = Integer.parseInt(st.nextToken());
                }

                if (type == 1) {
                    preSpeed[i] = speed;
                    if (i >= 2) {
                        preSpeed[i] = speed + preSpeed[i - 1];
                    }
                } else if (type == 2) {
                    if (preSpeed[i - 1] < speed) {
                        preSpeed[i] = 0;
                    } else {
                        preSpeed[i] = preSpeed[i-1] - speed;
                    }
                } else {
                    preSpeed[i] = preSpeed[i - 1];
                }
            }

            int distance = 0;
            for (int i = 0; i < preSpeed.length; i++) {
                distance += preSpeed[i];
            }

            System.out.println("#" + test_case + " " + distance);
        }
    }
}
