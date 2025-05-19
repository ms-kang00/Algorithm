import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int aCompany = 0;
            for (int i = 0; i < w; i++) {
                aCompany += p;
            }

            int bCompany = q;
            if (w > r) {
                for (int i = r; i < w; i++) {
                    bCompany += s;
                }
            }

            int min = 0;
            min = Math.min(aCompany, bCompany);
            bw.write("#" + test_case + " " + min + "\n");
        }
        bw.flush();
        bw.close();
    }

}