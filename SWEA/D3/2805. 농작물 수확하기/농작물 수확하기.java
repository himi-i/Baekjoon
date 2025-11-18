import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
		int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int mid = N / 2;
           for(int i = 0; i <N; i++){
               String line = br.readLine();
               for(int j = 0; j < N; j++){
                   arr[i][j] = line.charAt(j) - '0';
               }
           }
            int result = 0;
            
            for(int i = 0; i < N; i++){
                int d = Math.abs(mid - i);
                int start = d;
                int end = N - 1 - d;
                
                for(int j = start; j <= end; j++ ){
                result += arr[i][j];
               
                }
            }
            System.out.println("#" + test_case + " " + result);
		}
	}
}