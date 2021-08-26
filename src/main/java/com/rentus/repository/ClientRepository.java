package com.rentus.repository;

import com.rentus.models.Client;

import java.util.List;

public interface ClientRepository {
    void Register(Client client);
    Client getCLientbyId(int id);
//    boolean checkUserExistsByEmail(String email);
//    boolean checkUserUsername(Client client);

    Client Login(Client client);

    List<Client> allClients();
}

