import java.io.*;
import java.util.*;

public class Solution {
    static String[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new String[N];
            for (int i = 0; i < N; i++) {
                arr[i] = st.nextToken();
            }

            int mid = N / 2;
            String[] front = new String[mid];
            String[] back = new String[mid];

            for (int i = 0; i < mid; i++) {
                front[i] = arr[i];
                if (N % 2 != 0) {
                    back[i] = arr[mid + i + 1];
                } else {
                    back[i] = arr[mid + i];
                }
            }

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < mid; i++) {
                System.out.print(front[i] + " " + back[i]);
                if (i < mid - 1) {
                    System.out.print(" ");
                }
            }
            if (N % 2 != 0) {
                System.out.print(" " + arr[mid]);
            }
            System.out.println();
        }
    }
}
