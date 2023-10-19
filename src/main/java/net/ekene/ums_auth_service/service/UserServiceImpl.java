package net.ekene.ums_auth_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.ekene.model.UserData;
import net.ekene.payload.AuthPayload;
import net.ekene.payload.UserDataDto;
import net.ekene.response.UserResponseVO;
import net.ekene.ums_auth_service.config.security.jwt.JwtUtil;
import net.ekene.ums_auth_service.repository.UserDataRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDataRepository userDataRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;


    @Override
    public UserResponseVO createUser(UserDataDto userDataDto) {
        UserData user = UserData.builder()
                .firstName(userDataDto.getFirstName())
                .lastName(userDataDto.getLastName())
                .email(userDataDto.getEmail())
                .role(userDataDto.getRole())
                .password(passwordEncoder.encode(userDataDto.getPassword()))
                .build();

        UserData userData1 = userDataRepository.save(user);
        return userData1.returnResponse();
    }

    @Override
    public UserResponseVO authenticateUser(AuthPayload authPayload) {
        Authentication authentication;
        authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authPayload.getEmail(),
                        authPayload.getPassword()
                )
        );
        var user = userDataRepository.findUserDataByEmailIgnoreCase(authPayload.getEmail())
                .orElseThrow();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return user.returnResponse(getToken(authPayload.getEmail()));
    }


    private String getToken (String email){
        String token = jwtUtil.generateToken(email);
        log.info("Token {}", token);
        log.info("user email {}", jwtUtil.extractUsername(token));
        return token;
    }
}
