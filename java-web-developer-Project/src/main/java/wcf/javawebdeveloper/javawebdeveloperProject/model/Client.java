package wcf.javawebdeveloper.javawebdeveloperProject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientId;

    private String clientName;

    @JsonBackReference
    @OneToMany(mappedBy = "fClient", targetEntity = Feature.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> cFeatures;

    public Client() {
    }

    public Client(String clientName, List<Feature> cFeatures) {
        this.clientName = clientName;
        this.cFeatures = cFeatures;
    }

    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<Feature> getcFeatures() {
        return cFeatures;
    }

    public void setcFeatures(List<Feature> cFeatures) {
        this.cFeatures = cFeatures;
    }
}
