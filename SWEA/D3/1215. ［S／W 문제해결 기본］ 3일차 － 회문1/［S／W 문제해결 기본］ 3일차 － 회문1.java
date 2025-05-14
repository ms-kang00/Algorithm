import java.io.*;
import java.util.*;

public class Solution
{
    static char[][] map;
    static List<String> list;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int length = Integer.parseInt(br.readLine());
            map = new char[8][8];
            list = new ArrayList<>();

            for (int i = 0; i < 8; i++) {
                String line = br.readLine();
                for (int j = 0; j < 8; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - length; j++) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < length; k++) {
                        sb.append(map[i][j + k]);
                    }
                    list.add(sb.toString());
                }
            }

            for (int j = 0; j < 8; j++) {
                for (int i = 0; i <= 8 - length; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < length; k++) {
                        sb.append(map[i + k][j]);
                    }
                    list.add(sb.toString());
                }
            }

            int sum = 0;
            for (String s : list) {
                String reversed = new StringBuilder(s).reverse().toString();
                if (s.equals(reversed)) {
                    sum++;
                }
            }

            bw.write("#" + test_case + " " + sum + "\n");
        }
        bw.flush();
        bw.close();
    }

}