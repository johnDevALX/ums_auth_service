package net.ekene.ums_auth_service.service;

import net.ekene.payload.AuthPayload;
import net.ekene.payload.UserDataDto;
import net.ekene.response.UserResponseVO;

public interface UserService {
    UserResponseVO createUser(UserDataDto userDataDto);
    UserResponseVO authenticateUser (AuthPayload authPayload);
}
