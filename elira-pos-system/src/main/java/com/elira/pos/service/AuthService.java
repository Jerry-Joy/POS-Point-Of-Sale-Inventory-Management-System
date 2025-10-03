package com.elira.pos.service;

import com.elira.pos.exceptios.UserException;
import com.elira.pos.payload.dto.UserDto;
import com.elira.pos.payload.response.AuthResponse;

public interface AuthService {

    AuthResponse signup(UserDto userDto) throws UserException;
    AuthResponse login(UserDto userDto) throws UserException;
}
