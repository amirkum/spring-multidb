package ru.crynet.spring.multidb.dao;

import java.util.List;

import ru.crynet.spring.multidb.entity.Account;

public interface AccountDao extends BaseDao {
    List<Account> findAll();
}
