package example;

public class RegularExam implements IExam {
    public static final int MIN_SCORE = 3;
    @Override
    public void passExam(ReportCard reportCard) {
        System.out.println(reportCard.getAcademic_subject() +
            (reportCard.getGrade() >= MIN_SCORE ? ": экзамен сдан" : ": экзамен не сдан"));
    }
}
