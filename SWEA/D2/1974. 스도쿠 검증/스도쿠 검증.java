import java.io.*;
import java.util.*;

public class Solution
 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            map = new int[9][9];

            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean sdokuRow = true;
            boolean sdokuColumn = true;
            boolean sdokuThreeMultiThree = true;

            for (int i = 0; i < 9; i++) {
                List<Integer> rowList = new ArrayList<>();
                for (int j = 0; j < 9; j++) {
                    rowList.add(map[i][j]);
                }
                Set<Integer> set = new HashSet<>(rowList);
                if (set.size() != rowList.size()) {
                    sdokuRow = false;
                }
            }

            for (int j = 0; j < 9; j++) {
                List<Integer> colList = new ArrayList<>();
                for (int i = 0; i < 9; i++) {
                    colList.add(map[i][j]);
                }
                Set<Integer> set = new HashSet<>(colList);
                if (set.size() != colList.size()) {
                    sdokuColumn = false;
                }
            }

            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {
                    List<Integer> threeMultiThreeArr = new ArrayList<>();
                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            threeMultiThreeArr.add(map[x][y]);
                        }
                    }
                    Set<Integer> set = new HashSet<>(threeMultiThreeArr);
                    if (set.size() != threeMultiThreeArr.size()) {
                        sdokuThreeMultiThree = false;
                    }
                }
            }

            if (!sdokuRow || !sdokuColumn || !sdokuThreeMultiThree) {
                System.out.println("#" + test_case + " " + 0);
            } else {
                System.out.println("#" + test_case + " " + 1);
            }
        }
    }
}
