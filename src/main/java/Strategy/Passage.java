package Strategy;

import Builder.ReportCard;
import ChainofResponsibilities.Validation;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@AllArgsConstructor
@Setter
public class Passage extends Validation {
    private final ExamStrategy exam;

    @Override
    public void handle(ReportCard reportCard) {
        exam.passExam(reportCard);
        Optional.ofNullable(next).ifPresent(n -> n.handle(reportCard));
    }
}
