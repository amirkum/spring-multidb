package ru.crynet.spring.multidb.dao;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ru.crynet.spring.multidb.entity.Account;

@SpringBootTest
public class AccountDaoTests {
    private static final Log logger = LogFactory.getLog(AccountDaoTests.class);

    @Autowired
    private AccountDao accountDao;

    @Test
    public void shouldFindAll() {
        List<Account> accounts = accountDao.findAll();
        logger.info(accounts.size());
        assertNotEquals(0, accounts.size());
    }
}
