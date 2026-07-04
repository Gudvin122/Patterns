package Decorator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class ExamDecorator implements Decorator {
    protected Decorator decorator;
}
