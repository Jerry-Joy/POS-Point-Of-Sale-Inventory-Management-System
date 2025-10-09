package com.elira.pos.service;

import com.elira.pos.exceptions.UserException;
import com.elira.pos.modal.User;

import java.util.List;

public interface UserService {
      User getUserFromToken(String token) throws UserException;
      User getCurrentUser() throws UserException;
      User getUserByEmail(String email) throws UserException;
      User getUserById(Long id) throws UserException, Exception;
      List<User> getAllUsers();
}
