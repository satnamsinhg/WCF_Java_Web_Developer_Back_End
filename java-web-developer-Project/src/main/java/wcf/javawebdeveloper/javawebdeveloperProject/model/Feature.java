package wcf.javawebdeveloper.javawebdeveloperProject.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WCFFEATURE")
public class Feature implements Comparable<Feature>{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "ID of the Feature", name = "id")
    private int fId;

    @ApiModelProperty(notes = "Title of the Feature", name = "title", required = true)
    private String fTitle;

    @ApiModelProperty(notes = "Description of the Feature", name = "description", required = true)
    private String fDescription;

    @ApiModelProperty(notes = "Client of the Feature", name = "client", required = true)
    @ManyToOne(targetEntity = Client.class)
    private Client fClient;

    @ApiModelProperty(notes = "Priority of the Feature", name = "priority", required = true)
    private int fClientPriority;

    @ApiModelProperty(notes = "Target Date of the Feature", name = "target Date", required = true)
    private Date fTargetDate;

    @ApiModelProperty(notes = "Product Area of the Feature", name = "productArea", required = true)
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
