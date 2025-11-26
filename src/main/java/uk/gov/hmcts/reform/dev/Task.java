package uk.gov.hmcts.reform.dev.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity

public class Task {
    // marks id as the primary key
    // tells database to autogenerate the key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}