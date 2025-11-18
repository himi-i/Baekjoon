import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {

          
            int t = Integer.parseInt(br.readLine());
            
            int[][] map = new int[100][100];

           
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxSum = 0;

        
            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                for (int j = 0; j < 100; j++) rowSum += map[i][j];
                maxSum = Math.max(maxSum, rowSum);
            }

          
            for (int j = 0; j < 100; j++) {
                int colSum = 0;
                for (int i = 0; i < 100; i++) colSum += map[i][j];
                maxSum = Math.max(maxSum, colSum);
            }

            
            int diag1 = 0;
            for (int i = 0; i < 100; i++) diag1 += map[i][i];
            maxSum = Math.max(maxSum, diag1);

          
            int diag2 = 0;
            for (int i = 0; i < 100; i++) diag2 += map[i][99 - i];
            maxSum = Math.max(maxSum, diag2);

            
            System.out.println("#" + tc + " " + maxSum);
        }
    }
}
