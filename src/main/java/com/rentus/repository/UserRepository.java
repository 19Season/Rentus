package com.rentus.repository;

import com.rentus.models.User;

public interface UserRepository {
    void register(User user);
    User get(String userName, String password);
}

