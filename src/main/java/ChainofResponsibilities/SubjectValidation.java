package ChainofResponsibilities;

import Builder.ReportCard;

import java.util.Optional;

public class SubjectValidation extends Validation {
    @Override
    public void handle(ReportCard reportCard) {
        if (reportCard.getAcademicSubject() == null || reportCard.getAcademicSubject().isBlank()) {
            System.out.println("Ошибка: предмет не указан");
            return;
        }
    Optional.ofNullable(next).ifPresent(n -> n.handle(reportCard));
    }
}
