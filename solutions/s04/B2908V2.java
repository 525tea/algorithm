package s04;

import java.util.*;

public class B2908V2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String A = s.next();
        String B = s.next();

        String reverse_A = "" + A.charAt(2) + A.charAt(1) + A.charAt(0);
        String reverse_B = "" + B.charAt(2) + B.charAt(1) + B.charAt(0);

        int numA = Integer.parseInt(reverse_A);
        int numB = Integer.parseInt(reverse_B);

        System.out.println(Math.max(numA, numB));
    }
}
/**
 * 입력이 세 자리수로 정해졌기 때문에 이렇게 해도 됨
 * 하지만 자리수를 모를땐 V1 방법을 권장함
 */