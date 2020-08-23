package wcf.javawebdeveloper.javawebdeveloperProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wcf.javawebdeveloper.javawebdeveloperProject.model.Client;
import wcf.javawebdeveloper.javawebdeveloperProject.service.ClientService;

import java.util.Optional;

@RestController
@RequestMapping(path = "/clients")
@CrossOrigin("http://localhost:4200")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public Client createClient(@RequestBody Client client){
        return clientService.creatClient(client);
    }

    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable int id){
        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable int id){
        clientService.deleteClientById(id);
    }

}
