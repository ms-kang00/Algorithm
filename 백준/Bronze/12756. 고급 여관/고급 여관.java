import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int attackA = Integer.parseInt(st.nextToken());
        int hpA = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int attackB = Integer.parseInt(st.nextToken());
        int hpB = Integer.parseInt(st.nextToken());

        while(true) {
            if (hpA <= 0 || hpB <= 0) {
                break;
            }
            hpA = hpA - attackB;
            hpB = hpB - attackA;
        }

        if (hpA > hpB) {
            System.out.println("PLAYER A");
        } else if (hpA <= 0 && hpB <= 0) {
            System.out.println("DRAW");
        } else {
            System.out.println("PLAYER B");
        }
    }

}
