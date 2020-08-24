package wcf.javawebdeveloper.javawebdeveloperProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcf.javawebdeveloper.javawebdeveloperProject.model.Client;
import wcf.javawebdeveloper.javawebdeveloperProject.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client creatClient(Client client){
        return clientRepository.save(client);
    }

    public Optional<Client> getClientById(int id){
        return clientRepository.findById(id);
    }

    public void deleteClientById(int id){
        clientRepository.deleteById(id);
    }

    public Optional<Client> getClientByName(String name){
        Optional<Client> client = clientRepository.findAll().stream().filter(f-> f.getClientName().equals(name)).findFirst();
        return client;
    }

}
