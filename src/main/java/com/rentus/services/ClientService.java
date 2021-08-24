package com.rentus.services;

import com.rentus.models.Client;

import java.util.List;

public interface ClientService {
 Client Login(Client client);


 void Register(Client client);

 List<Client> getClients();

}
