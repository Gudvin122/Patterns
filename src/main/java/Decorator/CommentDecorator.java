package Decorator;

import Builder.ReportCard;

public class CommentDecorator extends ExamDecorator{
    public CommentDecorator(Decorator decorator) {
        super(decorator);
    }

    @Override
    public void pass(ReportCard reportCard) {
        decorator.pass(reportCard);
        System.out.println("Комментарий: студент старался, но есть над чем работать.");
    }
}
