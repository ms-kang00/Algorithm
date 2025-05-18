import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String memory = br.readLine();
            char value = '0';
            int count = 0;

            for (int i = 0; i < memory.length(); i++) {
                if (memory.charAt(i) != value) {
                    count++;
                    value = memory.charAt(i);
                }

            }
            bw.write("#" + test_case + " " + count + "\n");
        }
        bw.flush();
        bw.close();
    }

}