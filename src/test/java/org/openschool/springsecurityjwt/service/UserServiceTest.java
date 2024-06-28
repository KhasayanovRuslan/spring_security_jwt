package org.openschool.springsecurityjwt.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.openschool.springsecurityjwt.domain.model.Role;
import org.openschool.springsecurityjwt.domain.model.User;
import org.openschool.springsecurityjwt.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@DisplayName("Тест компонента Service")
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    private UserService userService;

    private User user;

    private static final String username = "ruslanqwerty";
    private static final String email = "test@test.ru";
    private static final String password = "123456";
    private static final Role role = Role.ROLE_USER;


    @BeforeAll
    public static void initSuite() {
        System.out.println("Running Test");
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("Test END");
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new Test");
        userService = new UserService(userRepository);
        user = User.builder()
                .username(username)
                .email(email)
                .password(password)
                .role(role)
                .build();

        userRepository.save(user);
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("New test complete:");

        userRepository.deleteById(user.getId());
    }


    @Test
    @DisplayName("Тест на проверку исключения при попытке сохранить пользователя " +
            "с существующим именем или email в базу")
    void createTest() {
        assertThrows(RuntimeException.class, () -> {
            userService.create(user);
        });
    }

    @Test
    @DisplayName("Тест на проверку получения пользователя по имени")
    void getByUsernameTest() {
        String testUsername = username;
        User testUser = userRepository.findByUsername(testUsername).get();

        assertEquals(testUser.getUsername(), testUsername);
    }

    @Test
    @DisplayName("Тест на проверку исключения при отсутствии пользователя в базе")
    void getByUsernameExceptionTest() {
        String testUsername = "NotUsername";

        assertThrows(UsernameNotFoundException.class, () -> {
            userService.getByUsername(testUsername);
        });
    }

    @Test
    void userDetailsServiceTest() {
        String testUsername = username;
        User testUser = userRepository.findByUsername(testUsername).get();

        assertEquals(testUser.getUsername(), testUsername);
    }
}