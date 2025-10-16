package s03;

import java.io.*;
import java.util.StringTokenizer;

public class S25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sum_grade = 0;
        double sum_score = 0;
        for (int i = 0; i < 20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if (grade.equals("P")) continue;

            double parseGrade = 0.0;
            switch (grade){
                case "A+": parseGrade = 4.5; break;
                case "A0": parseGrade = 4.0; break;
                case "B+": parseGrade = 3.5; break;
                case "B0": parseGrade = 3.0; break;
                case "C+": parseGrade = 2.5; break;
                case "C0": parseGrade = 2.0; break;
                case "D+": parseGrade = 1.5; break;
                case "D0": parseGrade = 1.0; break;
                case "F": parseGrade = 0.0; break;
            }
            sum_score += score;
            sum_grade += score * parseGrade;
        }

        System.out.println(sum_grade/sum_score);
    }
}