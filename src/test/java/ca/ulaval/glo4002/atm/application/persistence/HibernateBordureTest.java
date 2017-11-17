package ca.ulaval.glo4002.atm.application.persistence;

import static org.junit.Assert.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.ulaval.glo4002.atm.application.jpa.EntityManagerProvider;
import ca.ulaval.glo4002.atm.domain.accounts.Account;
import ca.ulaval.glo4002.atm.domain.accounts.StandardAccount;
import ca.ulaval.glo4002.atm.infrastructure.persistence.HibernateAccountRepository;

public class HibernateBordureTest {

    private static final double BALANCE = 345.00;
    private static final int ACCOUNT_NUMBER = 222;

    private static EntityManagerFactory entityManagerFactory;

    private HibernateAccountRepository accountRepo;

    @BeforeClass
    public static void setUpClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("atm-test");
    }

    @Before
    public void setUp() {
        EntityManagerProvider.setEntityManager(entityManagerFactory.createEntityManager());

        accountRepo = new HibernateAccountRepository();
    }

    @Test
    public void test() {
        Account accountTest = new StandardAccount(ACCOUNT_NUMBER, BALANCE);

        new EntityManagerProvider().executeInTransaction(() -> accountRepo.persist(accountTest));
        // accountRepo.persist(accountTest);

        Account accountPersisted = accountRepo.findByNumber(ACCOUNT_NUMBER);

        assertEquals(accountPersisted.getAccountNumber(), accountTest.getAccountNumber());
    }
}
