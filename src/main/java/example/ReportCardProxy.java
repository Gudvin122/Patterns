package example;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReportCardProxy implements IReportCard{
    private final ReportCard realReportCard;
    private final String userRole;
    @Override
    public String getAcademic_subject() {
        return realReportCard.getAcademic_subject();
    }

    @Override
    public int getGrade() {
        return realReportCard.getGrade();
    }

    @Override
    public void setGrade(int grade) {
        if ("TEACHER".equals(userRole)) {
            realReportCard.setGrade(grade);
            System.out.println("Оценка успешно изменена.");
        } else {
            System.out.println("Ошибка доступа: Студент не может менять оценки!");
        }
    }
}
