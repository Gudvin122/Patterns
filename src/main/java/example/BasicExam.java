package example;

public class BasicExam implements IDecorator {
    @Override
    public void pass(ReportCard reportCard) {
        System.out.println("Базовая сдача экзамена по предмету: " + reportCard.getAcademic_subject());
    }
}
