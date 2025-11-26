package uk.gov.hmcts.reform.dev;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.Validation;

public class TaskTest {
    @Test
    void taskShouldStoreValuesCorrectly() {
        // creat task and set fields
        Task task = new Task();

        LocalDateTime due = LocalDateTime.of(2025, 12, 10, 12, 0);

        task.setTitle("My Test Task");
        task.setDescription("This is a test task");
        task.setStatus(Status.TO_DO);
        task.setDueDate(due);

        // assertions
        assertThat(task.getTitle()).isEqualTo("My Test Task");
        assertThat(task.getDescription()).isEqualTo("This is a test task");
        assertThat(task.getStatus()).isEqualTo(Status.TO_DO);
        assertThat(task.getDueDate()).isEqualTo(due);
    }

    @Test
    void taskWithoutTitleShouldFailValidation() {
        var validator = Validation.buildDefaultValidatorFactory().getValidator();
        // create task with no title
        Task task = new Task();
        task.setDescription("Some description");
        task.setStatus(Status.TO_DO);

        var violations = validator.validate(task);

        assertThat(violations).isNotEmpty();
    }
}