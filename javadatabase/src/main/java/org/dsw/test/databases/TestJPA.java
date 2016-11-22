package org.dsw.test.databases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestJPA {

    public EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("h2JPA");
    }

    public static void main(String[] args) {
        EntityManagerFactory emFactory = new TestJPA().getEntityManagerFactory();
        System.out.println(emFactory);
        EntityManager em = emFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        HolidayInfoEntity holidayInfo = em.find(HolidayInfoEntity.class, "1bj7i4fgeq6gn");
        System.out.println(holidayInfo.getHolidayReason());
        em.remove(holidayInfo);
        transaction.commit();
        emFactory.close();
    }
}
