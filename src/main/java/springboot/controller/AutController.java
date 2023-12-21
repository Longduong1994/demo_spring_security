package springboot.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.dto.request.LoginDto;
import springboot.dto.request.RegisterDto;
import springboot.dto.response.UserResponse;
import springboot.entity.User;
import springboot.service.impl.UserService;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AutController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterDto registerDto){
        return new ResponseEntity<>(userService.register(registerDto), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> handleLogin(@RequestBody LoginDto loginDto) {
        return new ResponseEntity<>(userService.login(loginDto), HttpStatus.OK);
    }
}
