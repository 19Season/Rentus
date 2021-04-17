package com.rentus.services;

import com.rentus.models.Client;
import com.rentus.models.User;
import com.rentus.repository.ClientRepository;
import com.rentus.repository.UserRepository;
import com.rentus.utility.RepoFactory;

public class UserManagementService implements UserService {
    private UserRepository userRepo;

    public UserManagementService() {
        this.userRepo = RepoFactory.getUserRepo();
    }

    @Override
    public User getUser(String userName, String password) {
        User user = userRepo.get(userName, password);
        return user;
    }



    @Override
    public void register(User user) {
        userRepo.register(user);
    }

}
