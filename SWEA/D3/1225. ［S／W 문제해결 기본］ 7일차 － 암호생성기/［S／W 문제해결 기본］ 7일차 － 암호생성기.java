import java.io.*;
import java.util.*;

public class Solution
{

    static Deque<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());

            queue = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 8; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }


            int decrease = 1;
            while (true) {
                int polledValue = queue.poll();
                int addData = polledValue - decrease;
                decrease++;
                if (decrease > 5) {
                    decrease = 1;
                }

                if (addData <= 0) {
                    addData = 0;
                    queue.offer(addData);
                    break;
                } else {
                    queue.offer(addData);
                }

            }

            System.out.print("#" + N + " ");
            for (int i = 0; i < 8; i++) {
                System.out.print(queue.pollFirst());
                if (i < 7) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
