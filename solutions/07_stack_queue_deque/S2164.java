import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) queue.offer(i);

        while (queue.size() > 1){
            queue.poll(); // 맨 앞 장 버리기

            if (queue.size() == 1) break; // 1장만 남았다면 종료
            queue.offer(queue.poll()); // 맨 앞 장을 꺼내 뒤에 삽입
        }

        System.out.println(queue.poll());
    }
}