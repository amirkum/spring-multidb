package ru.crynet.spring.multidb.dao;

import javax.persistence.EntityManager;

public interface BaseDao {
    EntityManager getEntityManager(Integer year);
    EntityManager getEntityManager();
}
