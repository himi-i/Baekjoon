import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            
            for(int j = 0; j < S.length(); j++){
                int count = 0;
                
                while(count < R){
                    sb.append(S.charAt(j));
                    count++;
                }
            }
            sb.append("\n");
            
        }
        System.out.print(sb);
    }
}