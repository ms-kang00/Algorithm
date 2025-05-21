import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringBuilder sb = new StringBuilder();
            String palindrome = br.readLine();
            char[] arr = palindrome.toCharArray();
            for (int i = arr.length - 1; i >= 0; i--) {
                sb.append(arr[i]);
            }
            if (palindrome.equals(sb.toString())) {
                bw.write("#" + test_case + " " + 1 + "\n");
            } else {
                bw.write("#" + test_case + " " + 0 + "\n");
            }

        }
        bw.flush();
        bw.close();
    }
}