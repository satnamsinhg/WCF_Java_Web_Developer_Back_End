package wcf.javawebdeveloper.javawebdeveloperProject.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wcf.javawebdeveloper.javawebdeveloperProject.Exception.ClientNotFoundException;
import wcf.javawebdeveloper.javawebdeveloperProject.model.Feature;
import wcf.javawebdeveloper.javawebdeveloperProject.service.FeatureService;

import java.util.List;
import java.util.Optional;

@ApiOperation(value = "/features", tags = "Feature Informatation Controller")
@RestController
@RequestMapping(path = "/features")
@CrossOrigin("http://localhost:4200")
public class FeatureController {

    @Autowired
    FeatureService featureService;

    @ApiOperation(value = "Post the Feature", response = Feature.class, httpMethod = "POST")
    @PostMapping
    public Feature postFeature(@RequestBody Feature feature){
        return featureService.createFeature(feature);
    }

    @ApiOperation(value = "Get the Feature", response = Feature.class, httpMethod = "GET")
    @GetMapping("/{id}")
    public Optional<Feature> getFeatureById(@PathVariable int id){
        return featureService.getFeatureById(id);
    }

    @ApiOperation(value = "Delete the Feature", response = void.class, httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public void deleteFeature(@PathVariable int id){
        featureService.deleteFeatureById(id);
    }

    @ApiOperation(value = "Find all the Features of Given Client", response = Feature.class, httpMethod = "GET")
    @RequestMapping("/clients/{name}")
    public List<Feature>  findFeaturesOfClient(@PathVariable String name) throws ClientNotFoundException {
        return featureService.findFeaturesByClientName(name);
    }

    @ApiOperation(value = "Find the size of Features of Given Client", response = Integer.class, httpMethod = "GET")
    @RequestMapping("/clients/size/{name}")
    public int  findFeaturesSizeOfClient(@PathVariable String name) throws ClientNotFoundException {
        return featureService.findLengthOfFeaturesByClientName(name);
    }

}
