import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                return;
            }
            String reverseWord = new StringBuilder(input).reverse().toString();

            if (input.equals(reverseWord)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}