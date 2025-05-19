import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            int result = 0;
            for (int i = 1; i <= 10; i++) {
                String pattern = str.substring(0, i);
                String next = str.substring(i, i * 2);

                if (pattern.equals(next)) {
                    result = i;
                    break;
                }
            }
            bw.write("#" + test_case + " " + result + "\n");

        }
        bw.flush();
        bw.close();
    }

}