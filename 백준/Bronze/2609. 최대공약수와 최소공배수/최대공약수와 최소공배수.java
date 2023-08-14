import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());

        int a = gcd(one, two);
        System.out.println(a);
        System.out.println(one * two / a);
        
        


    }


    public static int gcd(int one, int two){

        while(two != 0){

            int mod = one % two;
            one = two;
            two = mod;

        }
        return one;
    }
}