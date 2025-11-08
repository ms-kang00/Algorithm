import java.util.*;
import java.io.*;

public class Solution {

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String input = br.readLine();

            char[] charArray = input.toCharArray();
            int min = Integer.parseInt(input);
            int max = Integer.parseInt(input);
            for (int i = 0; i < charArray.length - 1; i++) {
                for (int j = i + 1; j < charArray.length; j++) {
                    swap(charArray, i, j);

                    if (charArray[0] != '0') {
                        min = Math.min(min, Integer.parseInt(new String(charArray)));
                        max = Math.max(max, Integer.parseInt(new String(charArray)));
                    }

                    swap(charArray, i, j);
                }
            }

            System.out.println("#" + test_case + " " + min + " " + max);
        }
    }

}