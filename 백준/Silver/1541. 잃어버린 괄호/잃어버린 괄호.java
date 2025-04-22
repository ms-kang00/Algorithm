import java.io.*;
import java.util.*;

public class Main {
    
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int result = 0;

        String[] minusNum = s.split("-");

        for (int i = 0; i < minusNum.length; i++) {
            String[] plusNum = minusNum[i].split("\\+");
            int sum = 0;
            for (String line : plusNum) {
                if (!line.isEmpty()) {

                    sum += Integer.parseInt(line);
                }
            }

            if (i==0) {
                result += sum;
            } else {
                result -= sum;
            }
        }

        bw.write(result + "\n");
        
        

        bw.flush();
        bw.close();
    }

}
