package uk.gov.hmcts.reform.dev;

import static org.assertj.core.api.Assertions.assertThat;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DatabaseConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void dataSourceShouldBeConfigured() throws Exception {
        assertThat(dataSource).isNotNull();

        // Try getting a connection to ensure DB connectivity
        try (var connection = dataSource.getConnection()) {
            assertThat(connection.isValid(2)).isTrue(); // timeout 2 seconds
        }
    }
}