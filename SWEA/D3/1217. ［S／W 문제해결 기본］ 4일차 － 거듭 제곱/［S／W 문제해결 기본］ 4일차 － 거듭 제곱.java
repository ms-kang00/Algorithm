import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int num = scanner.nextInt();
            int base = scanner.nextInt();
            int exponent = scanner.nextInt();

            int result = powValue(base, exponent);
            System.out.println("#" + num + " " + result);
        }


    }
    static int powValue(int base, int exponent) {
        int pow = 1;

        for (int i = 0; i < exponent; i++) {
            pow *= base;
        }

        return pow;
    }
}