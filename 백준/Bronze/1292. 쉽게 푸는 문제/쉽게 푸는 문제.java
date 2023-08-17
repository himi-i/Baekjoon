import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i = 0;
        int sum = 0;

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        while (B > 0) {
            i++;
            for (int j = 0; j < i; j++) {
                A--;
                B--;
                if (A <= 0) sum += i;
                if (B == 0) break;
            }
        }
        
        System.out.print(sum);
        
        } 

    }