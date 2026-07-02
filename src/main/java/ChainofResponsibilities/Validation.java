package ChainofResponsibilities;

import Builder.ReportCard;

public abstract class Validation {
    protected Validation next;
    public Validation setNext(Validation next) {
        this.next = next;
        return next;
    }
    public abstract void handle(ReportCard reportCard);
}
