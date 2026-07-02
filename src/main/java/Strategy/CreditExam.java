package Strategy;

import Builder.ReportCard;

public class CreditExam implements ExamStrategy {
    @Override
    public void passExam(ReportCard reportCard) {
        System.out.println(reportCard.getAcademicSubject() +
                (reportCard.isCredit() ? ": экзамен сдан" : ": экзамен не сдан"));
    }
}
