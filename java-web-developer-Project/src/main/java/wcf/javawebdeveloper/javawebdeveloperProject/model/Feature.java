package wcf.javawebdeveloper.javawebdeveloperProject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WCFFEATURE")
public class Feature implements Comparable<Feature>{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fId;

    private String fTitle;
    private String fDescription;

    @ManyToOne(targetEntity = Client.class)
    private Client fClient;

    private int fClientPriority;

    private Date fTargetDate;

    @Enumerated(EnumType.STRING)
    private ProductArea fProductArea;


    public Feature() {
    }

    public Feature(String fTitle, String fDescription, Client fClient, int fClientPriority, Date fTargetDate, ProductArea fProductArea) {
        this.fTitle = fTitle;
        this.fDescription = fDescription;
        this.fClient = fClient;
        this.fClientPriority = fClientPriority;
        this.fTargetDate = fTargetDate;
        this.fProductArea = fProductArea;
    }

    public int getfId() {
        return fId;
    }

    public void setfId(int fId) {
        this.fId = fId;
    }

    public String getfTitle() {
        return fTitle;
    }

    public void setfTitle(String fTitle) {
        this.fTitle = fTitle;
    }

    public String getfDescription() {
        return fDescription;
    }

    public void setfDescription(String fDescription) {
        this.fDescription = fDescription;
    }

    public int getfClientPriority() {
        return fClientPriority;
    }

    public void setfClientPriority(int fClientPriority) {
        this.fClientPriority = fClientPriority;
    }

    public Client getfClient() {
        return fClient;
    }

    public void setfClient(Client fClient) {
        this.fClient = fClient;
    }

    public Date getfTargetDate() {
        return fTargetDate;
    }

    public void setfTargetDate(Date fTargetDate) {
        this.fTargetDate = fTargetDate;
    }

    public ProductArea getfProductArea() {
        return fProductArea;
    }

    public void setfProductArea(ProductArea fProductArea) {
        this.fProductArea = fProductArea;
    }

    @Override
    public int compareTo(Feature o) {

        if(this.getfClientPriority() > o.getfClientPriority())
            return 1;
        else
            return -1;
    }
}
