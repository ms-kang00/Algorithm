import java.io.*;
import java.util.*;

public class Solution
{
    static int[][] sudoku;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sudoku = new int[9][9];
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean isValid = true;

            for (int i = 0; i < 9; i++) {
                boolean[] check = new boolean[10];
                for (int j = 0; j < 9; j++) {
                    int num = sudoku[i][j];
                    if (check[num]) {
                        isValid = false;
                        break;
                    }
                    check[num] = true;
                }
            }

            for (int j = 0; j < 9; j++) {
                boolean[] check = new boolean[10];
                for (int i = 0; i < 9; i++) {
                    int num = sudoku[i][j];
                    if (check[num]) {
                        isValid = false;
                        break;
                    }
                    check[num] = true;
                }
            }

            for (int x = 0; x < 9; x += 3) {
                for (int y = 0; y < 9; y += 3) {
                    boolean[] check = new boolean[10];
                    for (int i = x; i < x + 3; i++) {
                        for (int j = y; j < y + 3; j++) {
                            int num = sudoku[i][j];
                            if (check[num]) {
                                isValid = false;
                                break;
                            }
                            check[num] = true;
                        }
                    }
                }
            }
            bw.write("#" + test_case + " " + (isValid ? 1 : 0) + "\n");
        }
        bw.flush();
        bw.close();
    }

}