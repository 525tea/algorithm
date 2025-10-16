package s04;

import java.io.*;

public class B10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String reverse = new StringBuilder(str).reverse().toString();

        if(str.equals(reverse)){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}

