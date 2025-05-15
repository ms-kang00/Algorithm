import java.io.*;
import java.util.*;

public class Solution {
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int rawLength = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[1000];
            for (int i = 0; i < rawLength; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int num = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                int loc = Integer.parseInt(st.nextToken());
                int insert = Integer.parseInt(st.nextToken());

                for (int i = rawLength - 1; i >= loc; i--) {
                    arr[i + insert] = arr[i];
                }

                for (int i = 0; i < insert; i++) {
                    arr[i + loc] = Integer.parseInt(st.nextToken());
                }
            }
            bw.write("#" + test_case + " ");
            for (int i = 0; i < 10; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}