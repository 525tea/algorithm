package s11;
import java.io.*;

public class S4779 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) { // EOF
            int N = Integer.parseInt(line);
            int len = (int) Math.pow(3, N);
            char[] arr = new char[len];
            for (int i = 0; i < len; i++) arr[i] = '-'; // 초기화

            cantor(arr, 0, len);
            sb.append(arr).append("\n");
        }
        System.out.println(sb);
    }

    static void cantor(char[] arr, int start, int size) {
        // base condition
        if (size == 1) return; // '-' 유지

        // 가운데 구간 빈 칸으로 변경
        int div = size / 3;
        for (int i = start + div; i < start + div * 2; i++) {
            arr[i] = ' ';
        }

        // 왼쪽 구간 재귀
        cantor(arr, start, div);

        // 오른쪽 구간 재귀
        cantor(arr, start + div * 2, div);
    }
}