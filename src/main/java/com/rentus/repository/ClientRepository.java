package com.rentus.repository;

import com.rentus.models.Client;

public interface ClientRepository {
    void Register(Client client);


    void Login(Client client);
}

