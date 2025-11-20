import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc = 1; tc <=10; tc++){
        
         int len = Integer.parseInt(br.readLine());
            int mid = len / 2;
         char[][] arr = new char[8][8];
            for(int i =0; i < 8; i++){
                 char[] line = br.readLine().toCharArray();
            	for(int j = 0; j < 8; j++){
                	arr[i][j] = line[j];
                }
            }
        int count = 0;
            //열 기준
       for(int z = 0; z < 8; z++){                   
          for(int i = 0; i < (8 - len +1); i++){
             Boolean state = true;
          	for(int j = 0; j < mid; j++){
             if( arr[j + i][z] != arr[ len - 1 - j + i ][z] ){
             	 state = false;
                 break;
             }
                
            }
              if(state) count++;
          }
           
        }
            
            //행 기준
            for(int z = 0; z < 8; z++){                   
          for(int i = 0; i < (8 - len +1); i++){
             Boolean state = true;
          	for(int j = 0; j < mid; j++){
             if( arr[z][j + i] != arr[z][ len - 1 - j + i ] ){
             	 state = false;
                 break;
             }
                
            }
              if(state) count++;
          }
           
        }
            System.out.println("#" + tc + " " + count);
                }
	}
}