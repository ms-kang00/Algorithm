
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < n; i++) {
            String str = scan.nextLine();
            String[] result = str.split(" ");
            for (String arg : result) {
                StringBuilder sb = new StringBuilder(arg).reverse();
                System.out.print(sb + " ");
            }
            System.out.println();
        }
    }
}