package ru.kerporation.cqrsbankingapp.service.auth;

import io.github.ilyalisov.jwt.config.TokenParameters;
import io.github.ilyalisov.jwt.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kerporation.cqrsbankingapp.domain.exception.ResourceAlreadyExistsException;
import ru.kerporation.cqrsbankingapp.domain.model.Client;
import ru.kerporation.cqrsbankingapp.service.client.ClientService;
import ru.kerporation.cqrsbankingapp.web.dto.LoginRequestDto;
import ru.kerporation.cqrsbankingapp.web.dto.LoginResponseDto;
import ru.kerporation.cqrsbankingapp.web.security.jwt.JwtProperties;
import ru.kerporation.cqrsbankingapp.web.security.jwt.TokenType;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final TokenService tokenService;
    private final ClientService clientService;
    private final JwtProperties jwtProperties;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDto login(final LoginRequestDto request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        final LoginResponseDto response = new LoginResponseDto();
        response.setAccess(tokenService.create(TokenParameters.builder(request.getUsername(), TokenType.ACCESS.name(), jwtProperties.getAccess()).build()));
        response.setRefresh(tokenService.create(TokenParameters.builder(request.getUsername(), TokenType.REFRESH.name(), jwtProperties.getRefresh()).build()));
        return response;
    }

    @Override
    public void register(final Client client) {
        if (clientService.existsByUsername(client.getUsername())) {
            throw new ResourceAlreadyExistsException();
        }
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        clientService.create(client);
    }
}