import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int num = Integer.parseInt(br.readLine());
            int index = 0;
            int count = 0;

            String word = br.readLine();
            String str = br.readLine();

            while ((index = str.indexOf(word, index)) != -1) {
                count++;
                index += word.length();
            }


            bw.write("#" + num + " " + count + "\n");
        }
        bw.flush();
        bw.close();
    }

}