/**
 * Created by Екатерина on 24.01.2019.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class UsersDAOTest {
    private EntityManagerFactory factory;
    private EntityManager em;
    private UsersDAO dao;

    @Before
    public void setup() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = factory.createEntityManager();
        dao = new UsersDAO(em);
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
    public void testCreateEngineer() {
        em.getTransaction().begin();
        Engineer engineer = dao.createEngineer("engineer1");
        em.getTransaction().commit();

        assertNotEquals(0L, engineer.getId());
        assertEquals("engineer1", engineer.getLogin());

        Engineer found = em.find(Engineer.class, engineer.getId());
        assertNotNull(found);
        assertEquals("engineer1", found.getLogin());

        User foundByLogin = dao.findUser("engineer1");
        assertNotNull(foundByLogin);
        if (!(foundByLogin instanceof Engineer)) {
            fail("Expected an instance of Engineer but " + foundByLogin.getClass().getSimpleName() + " found");
        }
    }

    @Test
   // @Ignore
    public void refreshRemoved() {
        em.getTransaction().begin();
        Engineer engineer = dao.createEngineer("engineer1");
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.remove(engineer);
//        em.persist(engineer);
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.persist(engineer);
        em.getTransaction().commit();
    }
}