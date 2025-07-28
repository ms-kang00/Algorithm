import java.io.*;
import java.util.*;

public class Main {
    

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //스택 사용 삘(queue를 써야하는 것 같음)
        String line = br.readLine();
        Deque<Character> q = new ArrayDeque<>();
        int sum = 0;

        for (int i = 0; i < line.length(); i++) {
            Character ch = line.charAt(i);

            if (ch == '(') {
                q.push(ch);
            } else {
                q.pop();

                if (i - 1 > 0) {
                    if (line.charAt(i-1) == '(') {
                        sum += q.size();
                    } else {
                        sum += 1;
                    }
                }
            }
        }
        System.out.println(sum);
    }


}
