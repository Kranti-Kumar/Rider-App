package com.RidderApp.uberApp.controllers;

import com.RidderApp.uberApp.TestContainerConfiguration;
import com.RidderApp.uberApp.dto.LoginRequestDto;
import com.RidderApp.uberApp.dto.SignupDto;
import com.RidderApp.uberApp.entities.User;
import com.RidderApp.uberApp.entities.enums.Role;
import com.RidderApp.uberApp.repositories.RiderRepository;
import com.RidderApp.uberApp.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Set;

@AutoConfigureWebTestClient(timeout = "100000")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestContainerConfiguration.class)
class AuthControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RiderRepository riderRepository;

    private User user;

    @BeforeEach
    void setUpEach() {
        user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setRoles(Set.of(Role.RIDER));
    }

    @Test
    void testSignUp_success() {
        SignupDto signupDto = new SignupDto();
        signupDto.setEmail("test@example.com");
        signupDto.setName("Test name");
        signupDto.setPassword("password");

        webTestClient.post()
                .uri("/auth/signup")
                .bodyValue(signupDto)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.data.email").isEqualTo(signupDto.getEmail())
                .jsonPath("$.data.name").isEqualTo(signupDto.getName());
    }

    @Test
    void testLogin_success() {
        // First, sign up a user
        SignupDto signupDto = new SignupDto();
        signupDto.setEmail("login@example.com");
        signupDto.setName("Login User");
        signupDto.setPassword("password123");

        webTestClient.post()
                .uri("/auth/signup")
                .bodyValue(signupDto)
                .exchange()
                .expectStatus().isCreated();

        // Then login
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setEmail("login@example.com");
        loginRequestDto.setPassword("password123");

        webTestClient.post()
                .uri("/auth/login")
                .bodyValue(loginRequestDto)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.data.accessToken").exists();
    }

    @Test
    void testSignUp_duplicateEmail() {
        SignupDto signupDto = new SignupDto();
        signupDto.setEmail("duplicate@example.com");
        signupDto.setName("First User");
        signupDto.setPassword("password");

        // First signup - should succeed
        webTestClient.post()
                .uri("/auth/signup")
                .bodyValue(signupDto)
                .exchange()
                .expectStatus().isCreated();

        // Second signup with same email - should fail
        webTestClient.post()
                .uri("/auth/signup")
                .bodyValue(signupDto)
                .exchange()
                .expectStatus().is4xxClientError();
    }
}

