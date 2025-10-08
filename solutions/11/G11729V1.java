import java.io.*;

public class G11729V1 {

    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        hanoi(N, '1', '3', '2');
        System.out.println(count);
        System.out.println(sb);
    }

    public static void hanoi(int n, char from, char to, char via) {
        if (n == 1) {
            sb.append(from + " " + to + "\n");
            count++;
            return;
        }
        hanoi(n - 1, from, via, to);
        sb.append(from + " " + to + "\n");
        count++;
        hanoi(n - 1, via, to, from);
    }
}
