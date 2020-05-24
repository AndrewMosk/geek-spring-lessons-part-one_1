package ru.geekbrains;


import org.hibernate.cfg.Configuration;
import ru.geekbrains.persist.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // INSERT User
        EntityManager em = emFactory.createEntityManager();
        User user = new User(null, "alex", "password");

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }
}
