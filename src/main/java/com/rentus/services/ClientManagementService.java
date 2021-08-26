package com.rentus.services;

import com.rentus.models.Client;
import com.rentus.repository.ClientRepository;
import com.rentus.utility.RepoFactory;

import java.util.List;

public class ClientManagementService implements ClientService {
    private ClientRepository ClientRepo;

    public ClientManagementService() {
        this.ClientRepo = RepoFactory.getClientRepo();
    }

    @Override
    public Client Login(Client client) {
//        System.out.println("service" + ClientRepo.Login(client));
        return ClientRepo.Login(client);
    }

//        @Override
//        public Boolean checkUserByEmail(String email) {
//            return ClientRepo.checkUserExistsByEmail(email);
//        }
//
//        @Override
//        public Boolean checkUserByUsername(Client client) {
//            System.out.println("Service");
//            return ClientRepo.checkUserUsername(client);
//        }



    @Override
    public void Register(Client client) {
        ClientRepo.Register(client);
    }


    @Override
    public List<Client> getClients() {
        return ClientRepo.allClients();
    }


}
