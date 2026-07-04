import Adapter.ElectronicJournal;
import Adapter.ReportCardAdapter;
import Builder.ReportCard;
import ChainofResponsibilities.Validation;
import ChainofResponsibilities.GradeValidation;
import ChainofResponsibilities.SubjectValidation;
import Decorator.BasicExam;
import Decorator.CommentDecorator;
import Decorator.Decorator;
import Proxy.ReportCardProxy;
import Proxy.Role;
import Strategy.RegularExam;
import Strategy.Passage;

public class Main {
    public static void sendToMinistryOfEducation(ElectronicJournal journal) {
        System.out.println("Отправка данных...");
        System.out.println(journal.getCourseInfo());
        System.out.println("Статус: " + journal.getPassedStatus());
    }

    public static void main(String[] args) {
        ReportCard math = new ReportCard.Builder()
            .academicSubject("Математика")
            .grade(3)
            .build();

        Validation chain = new SubjectValidation();
        chain.setNext(new GradeValidation())
            .setNext(new Passage(new RegularExam()));
        chain.handle(math);

        Decorator decorator = new BasicExam();
        decorator = new CommentDecorator(decorator);
        decorator.pass(math);

        new ReportCardProxy(math, Role.STUDENT).setGrade(5);
        sendToMinistryOfEducation(new ReportCardAdapter(math));
    }
}
