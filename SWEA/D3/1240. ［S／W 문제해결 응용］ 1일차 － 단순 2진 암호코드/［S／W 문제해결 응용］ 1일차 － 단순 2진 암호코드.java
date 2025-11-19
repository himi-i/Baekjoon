import java.io.*;
import java.util.*;

public class Solution {
    static Map<String, Integer> codeMap = new HashMap<>();
    static {
        codeMap.put("0001101", 0);
        codeMap.put("0011001", 1);
        codeMap.put("0010011", 2);
        codeMap.put("0111101", 3);
        codeMap.put("0100011", 4);
        codeMap.put("0110001", 5);
        codeMap.put("0101111", 6);
        codeMap.put("0111011", 7);
        codeMap.put("0110111", 8);
        codeMap.put("0001011", 9);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            String codeLine = "";
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                if (line.contains("1")) codeLine = line; // 마지막 1 있는 줄 저장
            }

            // 뒤에서부터 마지막 1 위치 찾기
            int end = codeLine.lastIndexOf('1');
            String code56 = codeLine.substring(end - 55, end + 1); // 56자리 추출

            int[] numbers = new int[8];
            for (int i = 0; i < 8; i++) {
                String pattern = code56.substring(i * 7, (i + 1) * 7);
                numbers[i] = codeMap.get(pattern);
            }

            // 검증코드 계산
            int check = 0;
            int sum = 0;
            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0) check += numbers[i] * 3;
                else check += numbers[i];
                sum += numbers[i];
            }

            int result = (check % 10 == 0) ? sum : 0;
            System.out.println("#" + tc + " " + result);
        }
    }
}
