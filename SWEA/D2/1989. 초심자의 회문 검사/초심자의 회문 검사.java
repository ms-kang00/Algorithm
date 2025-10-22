import java.io.*;
import java.util.*;

public class Solution
 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String input = br.readLine();

            int result = 1;
            int left = 0;
            int right = input.length() - 1;

            while (left < right) {
                if (input.charAt(left) != input.charAt(right)) {
                    result = 0;
                    break;
                }
                left++;
                right--;
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
