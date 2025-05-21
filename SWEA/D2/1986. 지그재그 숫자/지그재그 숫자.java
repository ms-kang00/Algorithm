import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int sum = 0;

            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    sum -= i;
                } else {
                    sum += i;
                }
            }
            bw.write("#" + test_case + " " + sum + "\n");
        }
        bw.flush();
        bw.close();
    }
}