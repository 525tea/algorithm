package s03;

import java.io.*;
import java.util.*;

public class B5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[30];
        for (int i = 0; i < 28; i++) {
            int idx = Integer.parseInt(br.readLine()) - 1;
            arr[idx] = 1;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if (arr[i] == 0) list.add(i + 1);
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}