import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution
{
    static int[] arr;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[7];
            for (int i = 0; i < 7; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;
            set = new HashSet<>();
            for (int i = 0; i < 7; i++) {
                for (int j = i + 1; j < 7; j++) {
                    for (int k = j + 1; k < 7; k++) {
                        sum = arr[i] + arr[j] + arr[k];
                        set.add(sum);
                    }
                }
            }

            List<Integer> list = set.stream()
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());

            System.out.println("#" + test_case + " " + list.get(4));
        }
    }

}
