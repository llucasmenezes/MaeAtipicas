package MaesAtipicas.MaeAtipicas.controller;

import MaesAtipicas.MaeAtipicas.mapper.UserMapper;
import MaesAtipicas.MaeAtipicas.model.User;
import MaesAtipicas.MaeAtipicas.request.UserRequest;
import MaesAtipicas.MaeAtipicas.response.UserResponse;
import MaesAtipicas.MaeAtipicas.service.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request){
    User savedUser = userService.save(UserMapper.toUser(request));
    return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toUserResponse(savedUser));
    }

}
