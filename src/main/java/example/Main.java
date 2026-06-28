package example;

public class Main {
    public static void sendToMinistryOfEducation(IElectronicJournal journal) {
        System.out.println("Отправка данных...");
        System.out.println(journal.getCourseInfo());
        System.out.println("Статус: " + journal.getPassedStatus());
    }

    public static void main(String[] args) {
        ReportCard math = new ReportCard.ReportCardBuilder()
                .academic_subject("Математика")
                .grade(3)
                .build();

        ExamHandler chain = new SubjectValidationHandler();
        chain.setNext(new GradeValidationHandler())
                .setNext(new StudentExam(new RegularExam()));
        chain.handle(math);

        IDecorator decorator = new BasicExam();
        decorator = new CommentDecorator(decorator);
        decorator.pass(math);

        new ReportCardProxy(math, "STUDENT").setGrade(5);
        sendToMinistryOfEducation(new ReportCardAdapter(math));
    }
}
