import java.io.*;
import java.util.*;

public class Solution
{
    static int[] arriveTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            arriveTime = new int[N];
            for (int i = 0; i < N; i++) {
                arriveTime[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arriveTime);

            String result = "Possible";

            for (int i = 0; i < N; i++) {
                int time = arriveTime[i];

                int count = (time / M) * K;

                int customer = i + 1;

                if (count < customer) {
                    result = "Impossible";
                    break;
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }

}
