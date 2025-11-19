import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            String pattern = br.readLine();
            String text = br.readLine();

            int count = 0;
            int index = 0;

            while ((index = text.indexOf(pattern, index)) != -1) {
                count++;
                index++;
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}
