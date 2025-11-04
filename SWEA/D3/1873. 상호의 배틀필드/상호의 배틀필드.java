import java.io.*;
import java.util.*;

public class Solution {
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // 상, 하, 좌, 우
    static char[] tankShapes = {'^', 'v', '<', '>'};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            map = new char[H][W];

            int tankX = 0;
            int tankY = 0;
            int tankDir = 0;
            for (int i = 0; i < H; i++) {
                String input = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = input.charAt(j);

                    if (map[i][j] == '^') {
                        tankX = i; tankY = j; tankDir = 0;
                    } else if (map[i][j] == 'v') {
                        tankX = i; tankY = j; tankDir = 1;
                    } else if (map[i][j] == '<') {
                        tankX = i; tankY = j; tankDir = 2;
                    } else if (map[i][j] == '>') {
                        tankX = i; tankY = j; tankDir = 3;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            char[] command = input.toCharArray();

            for (char cmd : command) {
                if (cmd == 'S') {
                    int nx = tankX + dx[tankDir];
                    int ny = tankY + dy[tankDir];

                    while (nx >= 0 && ny >= 0 && nx < H && ny < W) {
                        if (map[nx][ny] == '*') {
                            map[nx][ny] = '.';
                            break;
                        } else if (map[nx][ny] == '#') {
                            break;
                        }

                        nx += dx[tankDir];
                        ny += dy[tankDir];
                    }
                } else {
                    int newDir = 0;

                    if (cmd == 'U') {
                        newDir = 0;
                    } else if (cmd == 'D') {
                        newDir = 1;
                    } else if (cmd == 'L') {
                        newDir = 2;
                    } else if (cmd == 'R') {
                        newDir = 3;
                    }

                    tankDir = newDir;
                    map[tankX][tankY] = tankShapes[tankDir];

                    int nx = tankX + dx[tankDir];
                    int ny = tankY + dy[tankDir];

                    if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
                        if (map[nx][ny] == '.') {
                            map[tankX][tankY] = '.';
                            tankX = nx;
                            tankY = ny;
                            map[tankX][tankY] = tankShapes[tankDir];
                        }
                    }
                }
            }

            System.out.print("#" + test_case + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }

        }
    }
}
