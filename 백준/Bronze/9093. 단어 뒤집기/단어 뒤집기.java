
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] result = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String arg : result) {
                sb.append(new StringBuilder(arg).reverse()).append(" ");
            }
            System.out.print(sb);
        }
    }
}