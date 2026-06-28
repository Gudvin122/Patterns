package example;

import java.util.Optional;

public class SubjectValidationHandler extends ExamHandler{
    @Override
    public void handle(ReportCard reportCard) {
        if (reportCard.getAcademic_subject() == null || reportCard.getAcademic_subject().isBlank()) {
            System.out.println("Ошибка: предмет не указан");
            return;
        }
        Optional.ofNullable(next).ifPresent(n -> n.handle(reportCard));
    }
}
