package example;

import lombok.RequiredArgsConstructor;

import static example.RegularExam.MIN_SCORE;

@RequiredArgsConstructor
public class ReportCardAdapter implements IElectronicJournal{
    private final ReportCard reportCard;
    @Override
    public String getCourseInfo() {
        return "Предмет: " + reportCard.getAcademic_subject();
    }

    @Override
    public String getPassedStatus() {
        return (reportCard.isCredit() || reportCard.getGrade() >= MIN_SCORE) ? "Сдан" : "Не сдан";
    }
}
