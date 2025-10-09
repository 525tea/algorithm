import java.io.*;

public class B27433V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(factorial(N));
    }

    static long factorial (long n) {
        // base condition
        if (n <= 1) return 1;

        // 재귀식
        return n * factorial(n - 1);
    }
}
