import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i1 = Integer.parseInt(st.nextToken());
        int i2 = Integer.parseInt(st.nextToken());
        System.out.println(GCD(i1, i2));
        System.out.println(LCM(i1, i2));
    }

    private static int GCD(int i1, int i2) {
        int i3;
        while (i1 % i2 != 0) {
            i3 = i1 % i2;
            i1 = i2;
            i2 = i3;
        }
        return i2;
    }

    private static int LCM(int i1, int i2) {
        int i3;
        i3 = (i1 * i2) / GCD(i1, i2);
        return i3;
    }
}
