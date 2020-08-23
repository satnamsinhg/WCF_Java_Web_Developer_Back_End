package wcf.javawebdeveloper.javawebdeveloperProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wcf.javawebdeveloper.javawebdeveloperProject.Exception.ClientNotFoundException;
import wcf.javawebdeveloper.javawebdeveloperProject.model.Feature;
import wcf.javawebdeveloper.javawebdeveloperProject.service.FeatureService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/features")
@CrossOrigin("http://localhost:4200")
public class FeatureController {

    @Autowired
    FeatureService featureService;

    @PostMapping
    public Feature postFeature(@RequestBody Feature feature){
        return featureService.createFeature(feature);
    }

    @GetMapping("/{id}")
    public Optional<Feature> getFeatureById(@PathVariable int id){
        return featureService.getFeatureById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFeature(@PathVariable int id){
        featureService.deleteFeatureById(id);
    }

    @RequestMapping("/clients/{name}")
    public List<Feature>  findFeaturesOfClient(@PathVariable String name) throws ClientNotFoundException {
        return featureService.findFeaturesByClientName(name);
    }
}
