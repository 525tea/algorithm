package s04;

import java.util.*;

public class B5622V2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int totalTime = 0;

        for (int i = 0; i < str.length(); i++) {
            totalTime += getDialTime(str.charAt(i));
        }

        System.out.println(totalTime);
    }

    static int getDialTime(char ch) {
        switch (ch) {
            case 'A': case 'B': case 'C':
                return 3;
            case 'D': case 'E': case 'F':
                return 4;
            case 'G': case 'H': case 'I':
                return 5;
            case 'J': case 'K': case 'L':
                return 6;
            case 'M': case 'N': case 'O':
                return 7;
            case 'P': case 'Q': case 'R': case 'S':
                return 8;
            case 'T': case 'U': case 'V':
                return 9;
            case 'W': case 'X': case 'Y': case 'Z':
                return 10;
            default:
                return 0; // 예외처리용 (알파벳 아닌 값이 들어올 때)
        }
    }
}