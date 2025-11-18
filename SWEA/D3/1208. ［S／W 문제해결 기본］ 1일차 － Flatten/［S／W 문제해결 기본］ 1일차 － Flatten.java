import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int TC = 1; TC <= 10; TC++){
           int dump_count = Integer.parseInt(br.readLine());
           String[] arr = br.readLine().split(" ");
            int[] height = new int[100];
            
            for(int i = 0; i < 100; i++){
            height[i] = Integer.parseInt(arr[i]);
            }
            
            
            while( dump_count-- > 0){
                
            int maxIdx = 0;
            int minIdx = 0;
            
                for (int i = 1; i < 100; i++) {
                    if (height[i] > height[maxIdx]) maxIdx = i;
                    if (height[i] < height[minIdx]) minIdx = i;
                }
                height[maxIdx]--;
                height[minIdx]++;
                        
            }
       
            int max = 0;
            int min = 100;
            int result = 0;
            
            for(int z= 0; z < 100; z++){
                if( max < height[z]) max = height[z];
                if( min > height[z]) min = height[z];
               }
            result = (max - min);
            System.out.println("#" + TC + " " + result);
        }
		

	
	}
}