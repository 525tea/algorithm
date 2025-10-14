package s11;
import java.io.*;

public class G2447 {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = '*';
            }
        }

        recur(0, 0, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void recur (int r, int c, int n) {
        // base condition
        if (n == 1) return;

        int div = n / 3;

        // 가운데 공백으로 바꾸기
        for (int i = r + div; i < r + div * 2; i++) {
            for (int j = c + div; j < c + div * 2; j++) {
                map[i][j] = ' ';
            }
        }

        recur(r, c, div);
        recur(r, c + div, div);
        recur(r, c + div * 2, div);

        recur(r + div, c , div);
        recur(r + div, c + div * 2, div);

        recur(r + div * 2, c, div);
        recur(r + div * 2, c + div, div);
        recur(r + div * 2, c + div * 2, div);
    }
}
