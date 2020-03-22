package ru.crynet.spring.multidb.dao;

import javax.persistence.EntityManager;

public interface BaseDao {
    EntityManager getEntityManager(int year);
    EntityManager getEntityManager();
}
