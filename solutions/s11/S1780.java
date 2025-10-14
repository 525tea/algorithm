package s11;
import java.io.*;
import java.util.StringTokenizer;

public class S1780 {
    static int N;
    static int[][] arr;
    static int cntm1, cnt0, cntp1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, N);
        sb.append(cntm1).append("\n").append(cnt0).append("\n").append(cntp1).append("\n");
        System.out.println(sb);
    }

    static boolean isUniform (int r, int c, int n) { // + base condition(size = 1, 1칸일 때) 기능도 함
        int first = arr[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (arr[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }

    static void recur(int r, int c, int n) { // (r, c)부터 시작하는 n*n 행렬
        if (isUniform(r, c, n)) {
            int first = arr[r][c];
            if (first == -1) cntm1++;
            else if (first == 0) cnt0++;
            else if (first == 1) cntp1++;
        } else {
            // 재귀
            int div = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    recur(r + i * div, c + j * div, div);
                }
            }
        }
    }
}
