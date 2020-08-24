package wcf.javawebdeveloper.javawebdeveloperProject.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wcf.javawebdeveloper.javawebdeveloperProject.model.Client;
import wcf.javawebdeveloper.javawebdeveloperProject.service.ClientService;

import java.util.List;
import java.util.Optional;

@ApiOperation(value = "/clients", tags = "Client Profile Controller")
@RestController
@RequestMapping(path = "/clients")
@CrossOrigin("http://localhost:4200")
public class ClientController {

    @Autowired
    ClientService clientService;

    @ApiOperation(value = "Create new Client", response = Client.class, httpMethod = "POST")
    @PostMapping
    public Client createClient(@RequestBody Client client){
        return clientService.creatClient(client);
    }

    @ApiOperation(value = "Get All Clients", response = Client.class, httpMethod = "GET")
    @GetMapping
    public List<Client> getCLients(){
        return clientService.getClientList();
    }

    @ApiOperation(value = "Get Client By ID", response = Client.class, httpMethod = "GET")
    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable int id){
        return clientService.getClientById(id);
    }

    @ApiOperation(value = "Delete Client By Id", response = void.class, httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable int id){
        clientService.deleteClientById(id);
    }
}
