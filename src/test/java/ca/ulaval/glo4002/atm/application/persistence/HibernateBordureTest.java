package ca.ulaval.glo4002.atm.application.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateBordureTest {

    @BeforeClass
    public static void setUpClass() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("atm-test");
    }

    @Test
    public void test() {

    }

}
