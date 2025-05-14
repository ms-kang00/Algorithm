import java.io.*;

public class Solution {
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());
            map = new char[100][100];

            for (int i = 0; i < 100; i++) {
                String line = br.readLine();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            int maxLen = 0;

            for (int len = 100; len >= 1; len--) {
                boolean found = false;

                for (int i = 0; i < 100; i++) {
                    for (int j = 0; j <= 100 - len; j++) {
                        StringBuilder sb = new StringBuilder();
                        for (int k = 0; k < len; k++) {
                            sb.append(map[i][j + k]);
                        }
                        String str = sb.toString();
                        String rev = new StringBuilder(str).reverse().toString();

                        if (str.equals(rev)) {
                            maxLen = len;
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }

                if (found) break;

                for (int j = 0; j < 100; j++) {
                    for (int i = 0; i <= 100 - len; i++) {
                        StringBuilder sb = new StringBuilder();
                        for (int k = 0; k < len; k++) {
                            sb.append(map[i + k][j]);
                        }
                        String str = sb.toString();
                        String rev = new StringBuilder(str).reverse().toString();

                        if (str.equals(rev)) {
                            maxLen = len;
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }

                if (found) break;
            }

			bw.write("#" + n + " " + maxLen + "\n");
        }
        bw.flush();
        bw.close();
    }
}