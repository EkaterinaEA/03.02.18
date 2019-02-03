
import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("En")
public class Engineer extends User {

    @OneToMany(fetch = FetchType.LAZY,
  //  cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
    mappedBy = "engineer")

    //@JoinTable(name = "engineer_subjects_map",
   // joinColumns = @JoinColumn(name = "engineer_fk", referencedColumnName = "id"),
   // inverseJoinColumns = @JoinColumn(name = "subject_fk", referencedColumnName = "id"))

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