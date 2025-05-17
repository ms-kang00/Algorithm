import java.io.*;
import java.util.*;

public class Solution {
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            list = new ArrayList<>();

            int rawLength = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < rawLength; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int commandCount = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < commandCount; i++) {
                String command = st.nextToken();
                if (command.equals("I")) {
                    int loc = Integer.parseInt(st.nextToken());
                    int count = Integer.parseInt(st.nextToken());

                    for (int j = 0; j < count; j++) {
                        list.add(loc + j, Integer.parseInt(st.nextToken()));
                    }
                } else if (command.equals("D")) {
                    int loc = Integer.parseInt(st.nextToken());
                    int count = Integer.parseInt(st.nextToken());

                    for (int j = 0; j < count; j++) {
                        list.remove(loc);
                    }
                } else if (command.equals("A")) {
                    int count = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < count; j++) {
                        list.add(Integer.parseInt(st.nextToken()));
                    }
                }


            }
            bw.write("#" + test_case + " ");
            for (int i = 0; i < 10; i++) {
                bw.write(list.get(i) + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}