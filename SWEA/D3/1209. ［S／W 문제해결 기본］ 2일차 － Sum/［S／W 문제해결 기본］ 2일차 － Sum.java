import java.io.*;
import java.util.*;

public class Solution
{
    static int[][] map;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int[] rowSum = new int[100];
            int[] colSum = new int[100];
            int diagonalSum1 = 0;
            int diagonalSum2 = 0;
            int rowMax = 0;
            int colMax = 0;
            map = new int[100][100];

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    rowSum[i] += map[i][j];
                }
                rowMax = Math.max(rowMax, rowSum[i]);
            }

            for (int j = 0; j < 100; j++) {
                for (int i = 0; i < 100; i++) {
                    colSum[j] += map[i][j];
                }
                colMax = Math.max(colMax, colSum[j]);
            }

            for (int i = 0; i < 100; i++) {
                for (int j = i; j < i + 1; j++) {
                    diagonalSum1 += map[i][j];
                }
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 99 - i; j >= 99 - i; j--) {
                    diagonalSum2 += map[i][j];
                }
            }

            int result = Math.max(Math.max(rowMax, colMax), Math.max(diagonalSum1, diagonalSum2));

            bw.write("#" + test_case + " " + result + "\n");
        }
        bw.flush();
        bw.close();
    }

}