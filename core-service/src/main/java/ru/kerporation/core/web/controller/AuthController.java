package ru.kerporation.core.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kerporation.common.domain.model.Client;
import ru.kerporation.core.service.auth.AuthService;
import ru.kerporation.core.web.dto.ClientDto;
import ru.kerporation.core.web.dto.LoginRequestDto;
import ru.kerporation.core.web.dto.LoginResponseDto;
import ru.kerporation.core.web.dto.OnCreate;
import ru.kerporation.core.web.dto.mapper.ClientMapper;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final AuthService authService;
    private final ClientMapper clientMapper;

    @PostMapping("/register")
    public void register(@RequestBody @Validated(OnCreate.class) final ClientDto dto) {
        final Client client = clientMapper.fromDto(dto);
        authService.register(client);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody @Valid final LoginRequestDto dto) {
        return authService.login(dto);
    }

}