package s09;
import java.io.*;
import java.util.*;

public class S10825 {
    static class Student {
        String name;
        int KoranScore;
        int EngScore;
        int MathScore;

        public Student(String name, int koranScore, int engScore, int mathScore) {
            this.name = name;
            KoranScore = koranScore;
            EngScore = engScore;
            MathScore = mathScore;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int KoranScore = Integer.parseInt(st.nextToken());
            int EngScore = Integer.parseInt(st.nextToken());
            int MathScore = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, KoranScore, EngScore, MathScore);
        }

        Arrays.sort(students, (o1, o2) -> {
           if (o1.KoranScore != o2.KoranScore) {
              return o2.KoranScore - o1.KoranScore;
           } else if (o1.EngScore != o2.EngScore) {
               return o1.EngScore - o2.EngScore;
           } else if (o1.MathScore != o2.MathScore) {
               return o2.MathScore - o1.MathScore;
           } else {
               return o1.name.compareTo(o2.name);
           }
        });

        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.name).append("\n");
        }
        System.out.println(sb);
    }
}
