import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;
        int spy1 = 0, spy2 = 0;

        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        for(int i = 0; i < 8; i++){
            for(int j = 1; j < 9; j++){
                if(sum - arr[i] - arr[j] == 100){
                    spy1 = arr[i];
                    spy2 = arr[j];
                }

            }
        }

        Arrays.sort(arr);
        for(int i = 0; i < 9; i++){
            if(arr[i] != spy1 && arr[i] != spy2)
            System.out.println(arr[i]);
        }



    }
}