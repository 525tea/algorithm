package s11;
import java.io.*;

public class S1992 {
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        recur(0, 0, N);
        System.out.println(sb);
    }

    static boolean isUniform (int r, int c, int n) { // (r, c)부터 시작하는 사이즈 n*n의 배열이 통일된 배열인지 확인
        int first = map[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (map[i][j] != first) return false;
            }
        }
        return true;
    }

    static void recur (int r, int c, int n) {
        if (isUniform(r, c, n)) {
            int first = map[r][c];
            sb.append(first);
        } else {
            int div = n / 2;
            sb.append("(");
            recur(r, c, div);
            recur(r, c + div, div);
            recur(r + div, c, div);
            recur(r + div, c + div, div);
            sb.append(")");
        }
    }
}
