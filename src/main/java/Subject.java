/**
 * Created by Екатерина on 24.01.2019.
 */

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subjects",
indexes = {
        @Index(name = "adress_index",
        columnList = "address")
})
public class Subject {
    @Id
    @GeneratedValue
    private long id;

    @Column
    //@Enumerated(EnumType.STRING)
    @Convert(converter = SubjKindConverter.class)
    private SubjKind kind;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "engineer_fk")
    private Engineer engineer;

    @Column(unique = true, nullable = false)
    private String cadNum;

    @Column
    private String title;

    @Column(nullable = false, length = 500)
    private String address;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModificationTime;

    public Subject() {
    }

    public Subject(String cadNum, String address) {
        this.cadNum = cadNum;
        this.address = address;
    }

    public SubjKind getKind() {
        return kind;
    }

    public void setKind(SubjKind kind) {
        this.kind = kind;
    }

    public String getCadNum() {
        return cadNum;
    }

    public void setCadNum(String cadNum) {
        this.cadNum = cadNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Engineer getEngineer() {
        return engineer;
    }

    public void setEngineer(Engineer engineer) {
        this.engineer = engineer;
    }

    public Date getLastModificationTime() {
        return lastModificationTime;
    }

    public void setLastModificationTime(Date lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }
}