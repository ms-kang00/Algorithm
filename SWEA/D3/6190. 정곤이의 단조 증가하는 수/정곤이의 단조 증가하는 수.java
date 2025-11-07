import java.io.*;
import java.util.*;

public class Solution {
    static int[] arr;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            list = new ArrayList<>();
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    boolean increase = false;
                    int num = arr[i] * arr[j];
                    char[] charArray = String.valueOf(num).toCharArray();
                    for (int k = 0; k < charArray.length - 1; k++) {
                        if (charArray[k] <= charArray[k + 1]) {
                            increase = true;
                        } else {
                            increase = false;
                            break;
                        }
                    }
                    if (increase) {
                        list.add(num);
                    }
                }
            }

            list.sort(null);
            if (!list.isEmpty()) {
                System.out.println("#" + test_case + " " + list.get(list.size() - 1));
            } else {
                System.out.println("#" + test_case + " " + -1);
            }
        }
    }
}
