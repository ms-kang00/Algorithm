import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Meeting> list = new ArrayList<>();
    static class Meeting implements Comparable<Meeting> {
        int start, end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            } 
            return this.end - o.end;
        }
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Meeting(start, end));
        }

        Collections.sort(list);
        int count = 0;
        int lastEndTime = 0;

        for (Meeting meetings : list) {
            if (meetings.start >= lastEndTime) {

                count++;
                lastEndTime = meetings.end;
            }

        }

        sb.append(count + "\n");
        System.out.print(count);
        br.close();
    }
}
