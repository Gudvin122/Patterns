package example;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@AllArgsConstructor
@Setter
public class StudentExam extends ExamHandler {
    private final IExam exam;

    @Override
    public void handle(ReportCard reportCard) {
        exam.passExam(reportCard);
        Optional.ofNullable(next).ifPresent(n -> n.handle(reportCard));
    }
}
