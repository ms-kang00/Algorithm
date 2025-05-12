import java.io.*;
import java.util.*;

public class Solution
{


    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 1;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                String s = String.valueOf(i);

                int a = 0;
                for (char c : s.toCharArray()) {
                    if (c == '3' || c == '6' || c == '9') {
                        a++;
                    }
                }

                if (a == 0) {
                    sb.append(i).append(" ");
                } else {
                    for (int j = 0; j < a; j++) {
                        sb.append("-");
                    }
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
        bw.flush();
        bw.close();
    }

}