import java.io.*;
import java.util.StringTokenizer;

public class S2630V4 {
    static int N;
    static int[][] arr;
    static int cnt_w, cnt_b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, N);
        sb.append(cnt_w).append("\n").append(cnt_b).append("\n");
        System.out.println(sb);
    }

    static boolean isUniform (int r, int c, int n) { // + base condition(size = 1, 1칸일 때) 기능도 함
        int first = arr[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (arr[i][j] != first) return false;
            }
        }
        return true;
    }

    static void recur(int r, int c, int n) { // (r, c)부터 시작하는 n*n 행렬
        if (isUniform(r, c, n)) {
            int first = arr[r][c];
            if (first == 0) cnt_w++;
            else cnt_b++; // (first == 1)
        } else {
            // 재귀
            int div = n / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    recur(r + i * div, c + j * div, div);
                }
            }
        }
    }
}
