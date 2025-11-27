package uk.gov.hmcts.reform.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.gov.hmcts.reform.dev.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

	// JpaRepository gives you free CRUD methods, like:
	//  - save()
	//  - findById()
	//  - findAll()
	//  - deleteById()
	// Spring Boot will automatically create a class behind the scenes.
	// You don’t write any SQL, Spring handles it.