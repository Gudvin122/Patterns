package Adapter;

import Builder.ReportCard;
import lombok.RequiredArgsConstructor;

import static Strategy.RegularExam.MIN_SCORE;

@RequiredArgsConstructor
public class ReportCardAdapter implements ElectronicJournal {
    private final ReportCard reportCard;
    @Override
    public String getCourseInfo() {
        return "Предмет: " + reportCard.getAcademicSubject();
    }

    @Override
    public String getPassedStatus() {
        return (reportCard.isCredit() || reportCard.getGrade() >= MIN_SCORE) ? "Сдан" : "Не сдан";
    }
}
