package ru.crynet.spring.multidb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ru.crynet.spring.multidb.dao.AccountDao;
import ru.crynet.spring.multidb.entity.Account;

@Repository
public class AccountDaoImpl extends BaseDaoImpl implements AccountDao {
    @Override
    public List<Account> findAll(Integer year) {
        return getEntityManager(year).createQuery("FROM Account", Account.class)
                .getResultList();
    }

    @Override
    public List<Account> findAll() {
        return findAll(null);
    }
}
