package com.elira.pos.controller;

import com.elira.pos.exceptios.UserException;
import com.elira.pos.mapper.UserMapper;
import com.elira.pos.modal.User;
import com.elira.pos.payload.dto.UserDto;
import com.elira.pos.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getUserProfile(
            @RequestHeader("Authorization") String jwt
    ) throws UserException {
        User user=userService.getUserFromToken(jwt);
        return ResponseEntity.ok(UserMapper.toDTO(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws UserException, Exception {
        User user=userService.getUserById(id);
        return ResponseEntity.ok(UserMapper.toDTO(user));
    }
}
