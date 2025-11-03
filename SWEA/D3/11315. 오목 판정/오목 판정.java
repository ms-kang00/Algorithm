import java.io.*;
import java.util.*;

public class Solution
{
    static char[][] board;
    // 우, 하, 우하, 우상
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            board = new char[N][N];
            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    board[i][j] = input.charAt(j);
                }
            }

            boolean check = false;

            for (int x = 0; x < N; x++) {
                if (check) break;
                for (int y = 0; y < N; y++) {
                    if (check) break;

                    if (board[x][y] != 'o') {
                        continue;
                    }


                    for (int d = 0; d < 4; d++) {
                        int count = 1;
                        int curX = x;
                        int curY = y;
                        for (int k = 0; k < 4; k++) {
                            int nx = curX + dx[d];
                            int ny = curY + dy[d];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                                break;
                            }

                            if (board[nx][ny] != 'o') {
                                break;
                            }
                            count++;

                            curX = nx;
                            curY = ny;
                        }
                        if (count == 5) {
                            check = true;
                            break;
                        }
                    }
                }
            }

            if (check) {
                System.out.println("#" + test_case + " " + "YES");
            } else {
                System.out.println("#" + test_case + " " + "NO");
            }
        }
    }

}
