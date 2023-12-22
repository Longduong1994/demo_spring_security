package springboot.service.impl;

import springboot.dto.request.LoginDto;
import springboot.dto.request.RegisterDto;
import springboot.dto.response.UserResponse;
import springboot.entity.User;
import springboot.exception.LoginException;
import springboot.exception.RegisterException;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    String register(RegisterDto registerDto) throws RegisterException;

    UserResponse login(LoginDto loginDto) throws LoginException;
}
