import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static class Queue {
        private int[] data;
        private int front, rear, size;

        public Queue(int capacity) {
            data = new int[capacity];
            front = 0;
            rear = 0;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == data.length;
        }

        public void offer(int card) {
            if (isFull()) return;
            data[rear] = card;
            rear = (rear + 1) % data.length;
            size++;
        }

        public int poll() {
            if (isEmpty()) return -1;
            int removed = data[front];
            front = (front + 1) % data.length;
            size--;
            return removed;
        }

        public int peek() {
            if (isEmpty()) return -1;
            return data[front];
        }
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Queue q = new Queue(N);

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        while (q.size > 1) {
            q.poll();
            q.offer(q.poll());
        }
        bw.write(q.poll() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

   
}
