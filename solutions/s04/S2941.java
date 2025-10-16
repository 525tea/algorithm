package s04;

import java.io.*;

public class S2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String edited = str
                .replace("dz=", "*")
                .replace("c=", "*")
                .replace("c-", "*")
                .replace("d-", "*")
                .replace("lj", "*")
                .replace("nj", "*")
                .replace("s=", "*")
                .replace("z=", "*");

        System.out.println(edited.length());
    }
}