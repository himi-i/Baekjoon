import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());

            int index = 0;

            while(n>0){
                if(n%2 == 1){   //2로 나눴을 때 1이면 이진수로 1이고, 0이면 0이다.
                    System.out.print(index + " ");
                }

                n/=2;
                index++;
            }
            System.out.println();

        }

    }
}
