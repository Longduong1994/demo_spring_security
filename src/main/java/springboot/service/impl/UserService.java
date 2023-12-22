package springboot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springboot.config.SecurityConfig;
import springboot.dto.request.LoginDto;
import springboot.dto.request.RegisterDto;
import springboot.dto.response.UserResponse;
import springboot.entity.Role;
import springboot.entity.User;
import springboot.exception.LoginException;
import springboot.exception.RegisterException;
import springboot.repository.RoleRepository;
import springboot.repository.UserRepository;
import springboot.security.jwt.JwtProvider;
import springboot.security.user_principle.UserPrincipal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationProvider authenticationProvider;
    private final JwtProvider jwtProvider;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public String register(RegisterDto registerDto) throws RegisterException {
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new RegisterException("User is exits");
        }
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new RegisterException("Email is exits");
        }
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName("USER"));
        User user = User.builder()
                .username(registerDto.getUsername())
                .email(registerDto.getEmail())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .status(true)
                .roles(roles).build();
        userRepository.save(user);
        return "Register successfully";
    }

    @Override
    public UserResponse login(LoginDto loginDto) throws LoginException {
        Authentication authentication;
        try {
            authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        } catch (AuthenticationException ex) {
            throw new RuntimeException("username or password invalid");
        }

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        if (userPrincipal.getUser().isStatus() == false){
            throw new LoginException("Account is locked");
        }
        String token = jwtProvider.generateToken(userPrincipal);
        UserResponse userResponse = UserResponse.builder()
                .id(userPrincipal.getUser().getId())
                .username(userPrincipal.getUser().getUsername())
                .email(userPrincipal.getUser().getEmail())
                .token(token)
                .roles(userPrincipal.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toSet()))
                .build();

        return userResponse;
    }



}
