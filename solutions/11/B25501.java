import java.io.*;

public class B25501V2 {
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String in = br.readLine();
            cnt = 0;
            int res = isPalindrome(in);
            sb.append(res).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static int recur(String s, int l, int r) {
        cnt++;
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else return recur(s, l + 1, r - 1);
    }

    static int isPalindrome (String s) {
        return recur(s, 0, s.length() - 1);
    }
}
