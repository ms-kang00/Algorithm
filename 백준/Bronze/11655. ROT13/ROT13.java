import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c =  (char) ((c-'A' + 13) % 26 + 'A');
            } else if (c >= 'a' && c <= 'z') {
                c = (char) ((c-'a' + 13) % 26 + 'a');
            }
            System.out.print(c);
        }

    }
}