package example;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class ExamDecorator implements IDecorator {
    protected IDecorator decorator;
}
