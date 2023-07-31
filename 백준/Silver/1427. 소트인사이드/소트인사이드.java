import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] count = new int[10];
        String s = br.readLine();

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - '0']++;

        }
        for(int j = 9; j >= 0; j--){
            while (count[j]-- > 0)
                System.out.print(j);
        }

    }

}



