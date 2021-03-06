package com.rentus.services;

import com.rentus.models.Client;
import com.rentus.repository.ClientRepository;
import com.rentus.utility.RepoFactory;

public class ClientManagementService implements ClientService {
    private ClientRepository ClientRepo;

    public ClientManagementService() {
        this.ClientRepo = RepoFactory.getClientRepo();
    }

    @Override
    public Boolean Login(Client client) {
        ClientRepo.Login(client);
        return true;
    }



    @Override
    public void Register(Client client) {
        ClientRepo.Register(client);
    }

}
