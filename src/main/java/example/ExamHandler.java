package example;

public abstract class ExamHandler {
    protected ExamHandler next;
    public ExamHandler setNext(ExamHandler next) {
        this.next = next;
        return next;
    }
    public abstract void handle(ReportCard reportCard);
}
