package Decorator;

import Builder.ReportCard;

public class BasicExam implements Decorator {
    @Override
    public void pass(ReportCard reportCard) {
        System.out.println("Базовая сдача экзамена по предмету: " + reportCard.getAcademicSubject());
    }
}
