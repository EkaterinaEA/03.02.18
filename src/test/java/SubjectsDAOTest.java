/**
 * Created by Екатерина on 24.01.2019.
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SubjectsDAOTest {
    private EntityManagerFactory factory;
    private EntityManager em;
    private UsersDAO users;
    private SubjectsDAO subjects;

    @Before
    public void setup() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = factory.createEntityManager();
        users = new UsersDAO(em);
        subjects = new SubjectsDAO(em);
    }

    @After
    public void stop() {
        if (em != null) {
            em.close();
        }
        if (factory != null) {
            factory.close();
        }
    }

    @Test
    public void testCreateSubj() {
        em.getTransaction().begin();

        Engineer engineer = users.createEngineer("e2");
        Subject subject = subjects.createSubject(engineer, SubjKind.BUILDING, "78:0001:0001", "addr1");

        em.getTransaction().commit();
    }

    @Test
    public void testFindEngineersSubjs() {
        em.getTransaction().begin();

        Engineer engineer = users.createEngineer("e3");
        Subject subject = subjects.createSubject(engineer, SubjKind.BUILDING, "79:0001:0001", "addr2");
        engineer.setSubjects(Arrays.asList(subject));

        em.getTransaction().commit();

        em.refresh(engineer);

        List<Subject> found = engineer.getSubjects();
        System.out.println(found);
        assertNotNull(found);
        assertNotEquals(0, found.size());
        assertSame(subject, found.get(0));
    }
}