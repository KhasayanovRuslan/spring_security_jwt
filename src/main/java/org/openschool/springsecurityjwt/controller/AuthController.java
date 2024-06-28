package org.openschool.springsecurityjwt.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.openschool.springsecurityjwt.domain.dto.JwtAuthenticationTokenResponse;
import org.openschool.springsecurityjwt.domain.dto.RefreshJwtRequest;
import org.openschool.springsecurityjwt.domain.dto.SignInRequest;
import org.openschool.springsecurityjwt.domain.dto.SignUpRequest;
import org.openschool.springsecurityjwt.service.AuthenticationService;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация и Авторизация")
public class AuthController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public JwtAuthenticationTokenResponse signUp(@RequestBody @Valid SignUpRequest request) {

        return authenticationService.signUp(request);
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public JwtAuthenticationTokenResponse signIn(@RequestBody @Valid SignInRequest request) {

        return authenticationService.signIn(request);
    }

    @Operation(summary = "Принимает рефреш-токен и выдает новый токен")
    @PostMapping("/token")
    public JwtAuthenticationTokenResponse getNewAccessToken(@RequestBody RefreshJwtRequest request) {

        return authenticationService.getAccessToken(request.getRefreshToken());
    }

    @PostMapping("/refresh")
    public JwtAuthenticationTokenResponse getNewRefreshToken(@RequestBody RefreshJwtRequest request) {

        return authenticationService.refresh(request.getRefreshToken());
    }

}
