import java.io.*;

public class G2448 {
    static int N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int H = N;           // 높이
        int W = 2 * N - 1;   // 가로 길이 (중앙 정렬)
        arr = new char[H][W];

        // 모두 공백으로 초기화
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                arr[i][j] = ' ';
            }
        }

        // 꼭짓점 기준으로 그리기: (row=0, col=W/2)
        draw(0, W / 2, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            sb.append(arr[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void draw(int r, int c, int size) { // (r, c): 삼각형 꼭짓점 위치, size: 삼각형 높이
        if (size == 3) {
            // 최소 삼각형 3줄 그리기
            arr[r][c] = '*';
            arr[r + 1][c - 1] = arr[r + 1][c + 1] = '*';
            for (int k = -2; k <= 2; k++) arr[r + 2][c + k] = '*';
            return;
        }

        int half = size / 2;

        draw(r, c, half); // 위 삼각형
        draw(r + half, c - half, half); // 아래 왼쪽 삼각형
        draw(r + half, c + half, half); // 아래 오른쪽 삼각형
    }
}