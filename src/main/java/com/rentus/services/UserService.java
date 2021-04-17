package com.rentus.services;

import com.rentus.models.User;

public interface UserService {
 User getUser(String userName, String password);
 void register(User user);

}
