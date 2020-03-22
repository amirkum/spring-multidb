package ru.crynet.spring.multidb.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.crynet.spring.multidb.dao.BaseDao;

public abstract class BaseDaoImpl implements BaseDao {
    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @PersistenceContext(unitName = "2018")
    private EntityManager entityManager2018;

    @PersistenceContext(unitName = "2019")
    private EntityManager entityManager2019;

    @Override
    public EntityManager getEntityManager(Integer year) {
        if (year == null) {
            return entityManager;
        }

        switch (year) {
        case 2018:
            return entityManager2018;
        case 2019:
            return entityManager2019;
        default:
            return entityManager;
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
