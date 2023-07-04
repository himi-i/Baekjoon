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
            
            String[] SArr = S.split("");

            //S의 길이만큼 반복
            for(int j = 0; j<SArr.length; j++){
                //R번 만큼 반복
                for(int k = 0; k<R; k++)
                    sb.append(SArr[j]);
            }

            //문자열이 끝날 때마다 \n 추가
            sb.append("\n");
            
        }
        System.out.print(sb);
    }
}