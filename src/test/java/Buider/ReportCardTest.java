package Buider;

import Builder.ReportCard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Тестирование создания зачетной книжки (ReportCard)")
class ReportCardTest {

    @Test
    @DisplayName("Должен успешно создать экзамен с оценкой (без зачета)")
    void shouldCreateReportCardWithGradeOnly() {
        String expectedSubject = "Математика";
        int expectedGrade = 5;

        ReportCard actualReportCard = new ReportCard.Builder()
                .academicSubject(expectedSubject)
                .grade(expectedGrade)
                .credit(false)
                .build();

        assertAll("Проверка свойств экзамена",
                () -> assertThat(actualReportCard.getAcademicSubject()).isEqualTo(expectedSubject),
                () -> assertThat(actualReportCard.getGrade()).isEqualTo(expectedGrade),
                () -> assertThat(actualReportCard.isCredit()).isFalse()
        );
    }

    @Test
    @DisplayName("Должен успешно создать зачет (без оценки)")
    void shouldCreateReportCardWithCreditOnly() {
        String expectedSubject = "Физическая культура";

        ReportCard actualReportCard = new ReportCard.Builder()
                .academicSubject(expectedSubject)
                .grade(0)
                .credit(true)
                .build();

        assertAll("Проверка свойств зачета",
                () -> assertThat(actualReportCard.getAcademicSubject()).isEqualTo(expectedSubject),
                () -> assertThat(actualReportCard.getGrade()).isZero(),
                () -> assertThat(actualReportCard.isCredit()).isTrue()
        );
    }

    @Test
    @DisplayName("Должен выбросить исключение, если переданы одновременно и оценка, и зачет")
    void shouldThrowExceptionWhenBothGradeAndCreditAreProvided() {
        assertThatThrownBy(() -> new ReportCard.Builder()
                .academicSubject("История")
                .grade(5)
                .credit(true)
                .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("У зачета не может быть оценки");
    }
}
