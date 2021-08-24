package com.rentus.services;


import com.rentus.models.Admin;

public interface AdminService {
    Boolean login(Admin admin);


     void register(Admin admin);
}
