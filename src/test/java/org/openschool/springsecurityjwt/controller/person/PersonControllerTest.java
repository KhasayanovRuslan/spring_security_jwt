package org.openschool.springsecurityjwt.controller.person;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.openschool.springsecurityjwt.service.JwtAccessTokenService;
import org.openschool.springsecurityjwt.service.UserService;
import org.openschool.springsecurityjwt.service.person.PersonService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.openschool.springsecurityjwt.domain.model.Role.ROLE_USER;


@WebMvcTest(controllers = PersonController.class, properties = {"server.ssl.enabled=false"})
@DisplayName("Тест компонента Controller")
class PersonControllerTest {

    @MockBean
    PersonService servicePerson;

    @MockBean
    JwtAccessTokenService jwtServiceAccessToken;

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    public static void initSuite() {
        System.out.println("___Running Tests___");
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("___END Tests___");
    }

    @BeforeEach
    public void initTest() {
        System.out.println("___Starting new test___");
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("___New test end___");
    }

    @Test
    @WithAnonymousUser
    @DisplayName("Тест, если рользователь не авторизирован ->  статус ответа = 401")
    void givenRequestIsAnonymous_whenGetGreet_thenUnauthorized() throws Exception {
        mockMvc.perform(get("/persons/all"))
                .andExpect(status().isUnauthorized());
    }


    @Test
    @DisplayName("Тест, если рользователи не найдены ->  статус ответа = 204 isNoContent")
    void givenUserIsNotGrantedWithRoleAuthorizedPersonnel_whenGetSecuredRoute_thenForbidden() throws Exception {
        mockMvc.perform(get("/persons/all").with(SecurityMockMvcRequestPostProcessors.jwt()
                        .authorities(new SimpleGrantedAuthority(ROLE_USER.name()))))
                .andExpect(status().isNoContent());
    }
}
