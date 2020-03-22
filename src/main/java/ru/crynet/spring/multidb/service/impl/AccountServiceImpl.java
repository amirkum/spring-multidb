package ru.crynet.spring.multidb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.crynet.spring.multidb.dao.AccountDao;
import ru.crynet.spring.multidb.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void execute() {
        accountDao.findAll();
    }
}
