import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int max = Math.max(a, Math.max(b, c));

            if (a==0 && b==0 && c==0) {
                br.close();
                return;
            }

            if (a == max) {
                if (a * a == (b * b) + (c * c)) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            } else if (b == max) {
                if (b * b == (a * a) + (c * c)) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            } else if (c == max) {
                if (c * c == (a * a) + (b * b)) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            }

        }
    }
}