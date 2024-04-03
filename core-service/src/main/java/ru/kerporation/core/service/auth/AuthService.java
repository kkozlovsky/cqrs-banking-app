package ru.kerporation.core.service.auth;

import ru.kerporation.common.domain.model.Client;
import ru.kerporation.core.web.dto.LoginRequestDto;
import ru.kerporation.core.web.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(final LoginRequestDto request);

    void register(final Client client);
}