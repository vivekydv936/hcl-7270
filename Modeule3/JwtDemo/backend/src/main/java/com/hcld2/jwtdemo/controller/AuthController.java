package com.hcld2.jwtdemo.controller;

import com.hcld2.jwtdemo.dto.AuthRequest;
import com.hcld2.jwtdemo.dto.AuthResponse;
import com.hcld2.jwtdemo.entity.User;
import com.hcld2.jwtdemo.repository.UserRepository;
import com.hcld2.jwtdemo.security.JwtService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody AuthRequest request){
        if(userRepository.findByUsername(request.username()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error",String.valueOf("username already exists")));
        }

        // Continue with registration logic
        userRepository.save(new User(request.username(), passwordEncoder.encode((CharSequence) request.password())));
        return ResponseEntity.ok(Map.of("message","User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthRequest request){
        var userOptional = userRepository.findByUsername(request.username()).orElse(null);
        if(userOptional==null || !passwordEncoder.matches((CharSequence) request.password(),userOptional.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error","Invalid username or password"));
        }

        return ResponseEntity.ok(new AuthResponse(jwtService.generateToken(userOptional.getUsername()),userOptional.getUsername()));
    }


}
