package com.sahakian.springgithubactions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class SpringGithubActionsApplicationTests {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void successRequest() {
        webTestClient
                .get()
                .uri("/")
                .header("name", "John")
            .exchange()
            .expectBody()
            .jsonPath("$").isEqualTo("John");

        webTestClient
                .get()
                .uri("/")
                .header("name", "John")
                .exchange()
                .expectBody()
                .jsonPath("$").isEqualTo("Many request");
    }
}
