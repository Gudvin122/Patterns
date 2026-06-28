package example;

public class CreditExam implements IExam {
    @Override
    public void passExam(ReportCard reportCard) {
        System.out.println(reportCard.getAcademic_subject() +
            (reportCard.isCredit() ? ": экзамен сдан" : ": экзамен не сдан"));
    }
}
