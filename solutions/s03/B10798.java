package s03;

import java.io.*;

public class B10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[5][15];

        for(int i = 0; i < 5; i++) {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                arr[i][j] = str.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < 15; j++) {
            for(int i = 0; i < 5; i++) {
                if(arr[i][j]!='\0'){ // char[] 초기화는 char의 기본값 '\0'이 할당됨. '0'(X)!!!
                    sb.append(arr[i][j]);
                }
            }
        }
        System.out.println(sb);
    }
}