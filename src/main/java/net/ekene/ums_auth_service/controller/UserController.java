package net.ekene.ums_auth_service.controller;

import lombok.RequiredArgsConstructor;
import net.ekene.payload.AuthPayload;
import net.ekene.payload.UserDataDto;
import net.ekene.ums_auth_service.service.UserService;
import net.ekene.utility.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/user/")
public class UserController extends BaseController {
    private final UserService userService;

    @PostMapping("create")
    public ResponseEntity<?> createUser (@RequestBody UserDataDto userDataDto){
        return getResponse(HttpStatus.CREATED, "success", userService.createUser(userDataDto));
    }

    @PostMapping("authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthPayload authPayload){
        return getResponse(HttpStatus.OK, "success", userService.authenticateUser(authPayload));
    }

}
