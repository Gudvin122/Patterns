package Builder;

import lombok.*;

@Getter
@ToString
public class ReportCard {

    private final String academicSubject;
    private final int grade;
    private final boolean credit;

    private ReportCard(Builder builder) {
        this.academicSubject = builder.academicSubject;
        this.grade = builder.grade;
        this.credit = builder.credit;
    }

    public static class Builder {

        private String academicSubject;
        private int grade;
        private boolean credit;

        public Builder academicSubject(String academicSubject) {
            this.academicSubject = academicSubject;
            return this;
        }

        public Builder grade(int grade) {
            this.grade = grade;
            return this;
        }

        public Builder credit(boolean credit) {
            this.credit = credit;
            return this;
        }

        public ReportCard build() {
            if (this.academicSubject == null || this.academicSubject.trim().isEmpty()) {
                throw new IllegalStateException("Ошибка создания ReportCard: Название предмета не заполнено.");
            }
            if (!this.credit) {
                if (this.grade < 2 || this.grade > 5) {
                    throw new IllegalStateException("Ошибка создания ReportCard: Оценка за экзамен должна быть от 2 до 5.");
                }
            } else {
                if (this.grade != 0) {
                    throw new IllegalStateException("Ошибка создания ReportCard: У зачета не может быть оценки.");
                }
            }
            return new ReportCard(this);
        }
    }
}

