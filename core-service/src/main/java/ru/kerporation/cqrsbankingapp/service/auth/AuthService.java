package ru.kerporation.cqrsbankingapp.service.auth;

import ru.kerporation.cqrsbankingapp.domain.model.Client;
import ru.kerporation.cqrsbankingapp.web.dto.LoginRequestDto;
import ru.kerporation.cqrsbankingapp.web.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(final LoginRequestDto request);

    void register(final Client client);
}