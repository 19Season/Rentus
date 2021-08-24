package com.rentus.repository;


import com.rentus.models.Admin;
public interface AdminRepository {

     void register(Admin admin);

     public boolean login(Admin admin);


}
