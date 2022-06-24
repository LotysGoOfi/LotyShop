package by.itacademy.lotys.web.shop.lotyshop.util;


import lombok.Cleanup;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManager ENTITY_MANAGER = buildEntityManager();

    private static EntityManager buildEntityManager(){
        EntityManagerFactory persistenceUnitName =
                Persistence.createEntityManagerFactory("persistenceUnitName");
        return persistenceUnitName.createEntityManager();
    }
   public static EntityManager getEntityManager(){
        return ENTITY_MANAGER;
   }
}
