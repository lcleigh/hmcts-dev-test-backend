package uk.gov.hmcts.reform.dev.controllers;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import java.time.LocalDateTime;
import jakarta.validation.ConstraintViolationException;

import uk.gov.hmcts.reform.dev.repository.TaskRepository;
import uk.gov.hmcts.reform.dev.controllers.TaskController;
import uk.gov.hmcts.reform.dev.Task;
import uk.gov.hmcts.reform.dev.Status;




@SpringBootTest
class TaskControllerTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void shouldCreateTaskSuccessfully() {
        Task task = new Task();
        task.setTitle("Wash hair");
        task.setDescription("Wash and condition my hair");
        task.setStatus(Status.IN_PROGRESS);
        task.setDueDate(LocalDateTime.now().plusHours(2));

        Task savedTask = taskRepository.save(task);

        assertThat(savedTask.getId()).isNotNull();
        assertThat(savedTask.getTitle()).isEqualTo("Wash hair");
    }

    @Test
    void shouldCreateTaskSuccessfullyWhenNoDescription() {
        Task task = new Task();
        task.setTitle("Make Coffee");
        task.setStatus(Status.TO_DO);
        task.setDueDate(LocalDateTime.now().plusDays(1));

        Task savedTask = taskRepository.save(task);

        assertThat(savedTask.getId()).isNotNull();
        assertThat(savedTask.getTitle()).isEqualTo("Make Coffee");
    }

    @Test
    void shouldFailWhenTitleMissing() {
        Task task = new Task();
        task.setDescription("sort out my files");
        task.setStatus(Status.TO_DO);
        task.setDueDate(LocalDateTime.now().plusDays(3));

        assertThatThrownBy(() -> taskRepository.save(task))
            .isInstanceOf(ConstraintViolationException.class);
    }
}