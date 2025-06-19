import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
       
        int n = Integer.parseInt(br.readLine());

        
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if (input.startsWith("push")) {
                int x = Integer.parseInt(input.split(" ")[1]);
                stack.push(x);
            } else if (input.equals("pop")) {
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
            } else if (input.equals("size")) {
                sb.append(stack.size()).append('\n');
            } else if (input.equals("empty")) {
                sb.append(stack.isEmpty() ? 1 : 0).append('\n');
            } else if (input.equals("top")) {
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
            }
        }

       
        System.out.print(sb);
    }
}
