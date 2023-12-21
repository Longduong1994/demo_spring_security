package springboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.entity.User;
import springboot.service.impl.IUserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final IUserService userService;
    @GetMapping
    public ResponseEntity<List<User>>  findAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
}
