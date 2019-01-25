import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Ad")
public class Admin extends User {
    @Column
    private String region;

    public Admin() {
    }

    public Admin(String login) {
        setLogin(login);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}