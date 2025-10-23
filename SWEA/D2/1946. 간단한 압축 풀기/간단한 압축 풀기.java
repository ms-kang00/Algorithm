import java.io.*;
import java.util.*;

public class Solution
 {

     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            System.out.println("#" + test_case);

            int count = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String alphabet = st.nextToken();
                int length = Integer.parseInt(st.nextToken());

                for (int j = 0; j < length; j++) {
                    System.out.print(alphabet);
                    count++;

                    if (count == 10) {
                        System.out.println();
                        count = 0;
                    }
                }
            }

            System.out.println();
        }
    }
}
