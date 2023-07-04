import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		Integer.parseInt(br.readLine());	//readLine은 공백까지 받는다.
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
		while(st.hasMoreTokens()) {
		int next = Integer.parseInt(st.nextToken());
        max = Math.max(max, next);
        min = Math.min(min, next);
      }
		System.out.println(min + " " + max);
	}
}