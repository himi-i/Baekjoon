import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
		int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            }
            
            long sum = 0;
            long max = 0;
            
            for( int i = N-1; i >= 0; i--){
            if( arr[i] >= max ) max = arr[i];
            else sum += ( max - arr[i] );
            }
            System.out.println("#" + test_case + " " + sum);  
		
		}
	}
}