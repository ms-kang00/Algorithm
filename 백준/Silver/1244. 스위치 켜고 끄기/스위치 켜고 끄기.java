import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine());
        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            
            if (gender == 1) {
                man(loc, n);
            } else if (gender == 2) {
                woman(loc, n);
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
        
    }
    static void man(int loc, int num) {
        for (int i = loc; i <= num; i++) {
            if (i % loc == 0) {
                if (arr[i] == 1) {
                    arr[i] = 0;
                } else {
                    arr[i] = 1;
                }
            }
        }
    }

    static void woman(int loc, int num ) {
        int count = 1;
        if (arr[loc] == 1) {
            arr[loc] = 0;
        } else {
            arr[loc] = 1;
        }
        while ((loc - count) > 0 && (loc + count) <= num) {
            if (arr[loc - count] == arr[loc + count]) {
                if (arr[loc - count] == 1) {
                    arr[loc - count] = 0;
                    arr[loc + count] = 0;
                } else {
                    arr[loc - count] = 1;
                    arr[loc + count] = 1;
                }
                count++;
            } else {
                break;
            }
        }
    }
}
