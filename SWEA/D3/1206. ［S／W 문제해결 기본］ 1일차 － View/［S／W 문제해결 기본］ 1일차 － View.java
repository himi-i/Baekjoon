import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] buildings = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                buildings[i] = Integer.parseInt(st.nextToken());
            }

            int totalView = 0;
            
            for (int i = 2; i < N - 2; i++) {
                int left1 = buildings[i - 1];
                int left2 = buildings[i - 2];
                int right1 = buildings[i + 1];
                int right2 = buildings[i + 2];
                
                int maxNeighbor = Math.max(Math.max(left1, left2), Math.max(right1, right2));
                
                if (buildings[i] > maxNeighbor) {
                    totalView += buildings[i] - maxNeighbor;
                }
            }
            
            System.out.println("#" + test_case + " " + totalView);
        }
    }
}
