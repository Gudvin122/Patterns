package ChainofResponsibilities;

import Builder.ReportCard;

import java.util.Optional;

public class GradeValidation extends Validation {
    private static final int MIN_GRADE = 2;
    private static final int MAX_GRADE = 5;

    @Override
    public void handle(ReportCard reportCard) {
        if (reportCard.getGrade() < MIN_GRADE || reportCard.getGrade() > MAX_GRADE) {
            System.out.println("Ошибка: некорректная оценка");
            return;
        }
        Optional.ofNullable(next).ifPresent(n -> n.handle(reportCard));
    }
}
