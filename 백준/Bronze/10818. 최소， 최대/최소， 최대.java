import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int max = num;
        int min = num;

        for (int i = 1; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (number > max) {
                max = number;
            } else if (number < min) {
                min = number;
            }
        }
        System.out.println(min + " " + max);
        br.close();
    }
}