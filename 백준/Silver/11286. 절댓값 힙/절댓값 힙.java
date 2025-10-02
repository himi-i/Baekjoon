import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a), absB = Math.abs(b);
            if (absA != absB) return Integer.compare(absA, absB);
            return Integer.compare(a, b);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine().trim());
            if (x == 0) sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
            else pq.offer(x);
        }

        System.out.print(sb.toString());
    }
}
