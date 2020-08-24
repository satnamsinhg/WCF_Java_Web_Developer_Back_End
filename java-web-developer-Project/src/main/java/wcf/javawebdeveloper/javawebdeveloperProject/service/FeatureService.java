package wcf.javawebdeveloper.javawebdeveloperProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wcf.javawebdeveloper.javawebdeveloperProject.Exception.ClientNotFoundException;
import wcf.javawebdeveloper.javawebdeveloperProject.model.Client;
import wcf.javawebdeveloper.javawebdeveloperProject.model.Feature;
import wcf.javawebdeveloper.javawebdeveloperProject.repository.FeatureRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FeatureService {

    @Autowired
    FeatureRepository featureRepository;

    @Autowired
    ClientService clientService;

    public Feature createFeature(Feature feature){

        List<Feature> list;
        int clientId;

        if(feature.getfClient().getClientName() != null){
            String clientName = feature.getfClient().getClientName();
            Client client = this.findCLientFromFeaturesByName(clientName).get();
            feature.setfClient(client);
        }

        clientId = feature.getfClient().getClientId();

        list  = this.findFeaturesByClientId(clientId);

        Collections.sort(list);

        list.add(feature.getfClientPriority()-1, feature);

        list.stream().filter(f->f.getfClient().getClientId()== clientId).forEach(f -> f.setfClientPriority(list.indexOf(f)));

        return featureRepository.save(feature);
    }

    public Optional<Feature> getFeatureById(int id){
        return featureRepository.findById(id);
    }

    public void deleteFeatureById(int id){
        featureRepository.deleteById(id);
    }

    public List<Feature> findFeaturesByClientId(int clientId){
        List<Feature> list = featureRepository.findAll().stream().filter(feature -> feature.getfClient().getClientId()==clientId).collect(Collectors.toList());
        return list;
    }

    public Optional<Client> findCLientFromFeaturesByName(String clientName){
        Optional<Client> client = clientService.getClientByName(clientName);
        return client;
    }

    public List<Feature> findFeaturesByClientName(String clientName) throws ClientNotFoundException {
        try
        {
            int id = clientService.getClientByName(clientName).get().getClientId();

            List<Feature> list = new ArrayList<>();
            list = featureRepository.findAll().stream()
                    .filter(f->f.getfClient().getClientId()==id).collect(Collectors.toList());
            list.stream().forEach(f->f.setfClientPriority(f.getfClientPriority()+1));
            return list;
        }
        catch(NullPointerException e){
            throw new ClientNotFoundException("Client is not found Exception");

        }
    }

    public int findLengthOfFeaturesByClientName(String clientName){
        int id = clientService.getClientByName(clientName).get().getClientId();
        return (int)featureRepository
                .findAll()
                .stream()
                .filter(feature -> feature.getfClient().getClientId()==id)
                .count();
    }
}
