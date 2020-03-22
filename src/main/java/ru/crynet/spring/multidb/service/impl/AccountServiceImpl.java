package ru.crynet.spring.multidb.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.crynet.spring.multidb.dao.AccountDao;
import ru.crynet.spring.multidb.entity.Account;
import ru.crynet.spring.multidb.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private static final Log logger = LogFactory.getLog(AccountServiceImpl.class);

    @Autowired
    private AccountDao accountDao;

    @Override
    public void execute() {
        List<Account> accounts;
        accounts = accountDao.findAll(2018);
        logger.info(accounts.size());
        accounts = accountDao.findAll(2019);
        logger.info(accounts.size());
        accounts = accountDao.findAll();
        logger.info(accounts.size());
    }
}
