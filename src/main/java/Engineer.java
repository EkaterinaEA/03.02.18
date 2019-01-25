/**
 * Created by Екатерина on 24.01.2019.
 */
import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("En")
public class Engineer extends User {
    @OneToMany(fetch = FetchType.LAZY)
    private List<Subject> subjects;

    public Engineer() {
    }

    public Engineer(String login) {
        setLogin(login);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}