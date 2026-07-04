package Strategy;

import Builder.ReportCard;

public class RegularExam implements ExamStrategy {
    public static final int MIN_SCORE = 3;

    @Override
    public void passExam(ReportCard reportCard) {
        System.out.println(reportCard.getAcademicSubject() +
                (reportCard.getGrade() >= MIN_SCORE ? ": экзамен сдан" : ": экзамен не сдан"));
    }
}
