import java.io.*;
import java.util.*;

public class Solution
{
    static int[][] board;
    static int N;
    // 상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            board = new int[N][N];

            int mid = N / 2;
            board[mid - 1][mid - 1] = 2;
            board[mid - 1][mid] = 1;
            board[mid][mid - 1] = 1;
            board[mid][mid] = 2;

            // 1: 흑, 2: 백
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                int color = Integer.parseInt(st.nextToken());

                placeAndFlip(r, c, color);
            }

            int whiteCount = 0;
            int blackCount = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (board[r][c] == 1) blackCount++;
                    else if (board[r][c] == 2) whiteCount++;
                }
            }

            System.out.println("#" + test_case + " " + blackCount + " " + whiteCount);
        }
    }

    static void placeAndFlip(int r, int c, int color) {
        board[r][c] = color;
        int oppositeColor = (color == 1) ? 2 : 1;

        for (int d = 0; d < 8; d++) {
            List<Point> flipList = new ArrayList<>();

            int nr = r + dx[d];
            int nc = c + dy[d];

            while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (board[nr][nc] == 0) {
                    break;
                } else if (board[nr][nc] == color) {
                    for (Point p : flipList) {
                        board[p.r][p.c] = color;
                    }
                    break;
                } else if (board[nr][nc] == oppositeColor) {
                    flipList.add(new Point(nr, nc));
                }

                nr += dx[d];
                nc += dy[d];
            }

        }
    }
}
