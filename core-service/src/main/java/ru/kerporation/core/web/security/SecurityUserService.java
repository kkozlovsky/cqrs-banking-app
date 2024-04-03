package ru.kerporation.core.web.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.kerporation.common.domain.model.Client;
import ru.kerporation.core.service.client.ClientService;

@Service
@RequiredArgsConstructor
public class SecurityUserService implements UserDetailsService {

    private final ClientService clientService;

    @Override
    public SecurityUser loadUserByUsername(final String username) {
        final Client client = clientService.getByUsername(username);
        return new SecurityUser(client);
    }

}