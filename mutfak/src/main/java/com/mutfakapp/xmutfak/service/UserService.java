package com.mutfakapp.xmutfak.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mutfakapp.xmutfak.entity.User;
import com.mutfakapp.xmutfak.controller.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
