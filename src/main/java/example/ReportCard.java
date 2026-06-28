package example;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ReportCard implements IReportCard{
    private String academic_subject;
    private int grade;
    private boolean  credit;
}
