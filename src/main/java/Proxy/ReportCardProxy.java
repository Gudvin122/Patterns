package Proxy;

import Builder.ReportCard;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReportCardProxy implements Correction {
    private ReportCard realReportCard;
    private final Role userRole;
    @Override
    public String getAcademicSubject() {
        return realReportCard.getAcademicSubject();
    }

    @Override
    public int getGrade() {
        return realReportCard.getGrade();
    }

    @Override
    public void setGrade(int grade) {
        if (this.userRole == Role.TEACHER) {
            this.realReportCard = new ReportCard.Builder()
                .academicSubject(realReportCard.getAcademicSubject())
                .credit(realReportCard.isCredit())
                .grade(grade)
                .build();
        System.out.println("Оценка успешно изменена.");
        } else {
        System.out.println("Ошибка доступа: Студент не может менять оценки!");
        }
    }
}
