package s04;

import java.io.*;

public class B5622V1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int time = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('A' < c && c <= 'C') {
                time += 3;
            } else if ('E' < c && c <= 'F') {
                time += 4;
            } else if ('G' < c && c <= 'I') {
                time += 5;
            } else if ('J' < c && c <= 'L') {
                time += 6;
            } else if ('M' < c && c <= 'O') {
                time += 7;
            } else if ('P' < c && c <= 'S') {
                time += 8;
            } else if ('T' < c && c <= 'V') {
                time += 9;
            } else if ('W' < c && c <= 'Z') {
                time += 10;
            } else { // '0'
                continue;
            }
        }
        System.out.println(time);
    }
}
