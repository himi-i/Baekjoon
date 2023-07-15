

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public static int back = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                     //큐의 삽입,삭제,맨앞 값 탐색 메소드가 두개씩 있다. 리턴값이 다름
                    back = Integer.parseInt(st.nextToken());
                    q.offer(back);
                    break;

                case "pop":
                    if(q.isEmpty()) {
                        bw.write(-1 + "\n");
                    }
                    else
                        bw.write(q.poll() + "\n");
                    break;

                case "size":
                    bw.write(q.size() + "\n");
                    break;

                case "empty":
                    if(q.isEmpty()){
                        bw.write(1+"\n");
                    }
                    else
                        bw.write(0+"\n");
                    break;

                case "front":
                    if(q.isEmpty()) {
                        bw.write(-1 + "\n");
                    }
                    else
                        bw.write(q.peek() + "\n");
                    break;

                case "back":
                    if(q.isEmpty())
                        bw.write(-1+"\n");
                    else
                        bw.write(back+"\n");

            }
        }
        bw.flush();
        bw.close();
    }
}