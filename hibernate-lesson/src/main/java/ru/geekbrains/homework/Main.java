package ru.geekbrains.homework;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.homework.persist.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate1.cfg.xml")
                .buildSessionFactory();

        // INSERT customer
        EntityManager em = emFactory.createEntityManager();
        Customer customer = new Customer("Bob");
        Customer customer1 = new Customer("Bill");
        Customer customer2 = new Customer("Jack");

        em.getTransaction().begin();
        em.persist(customer);
        em.persist(customer1);
        em.persist(customer2);
        em.getTransaction().commit();
    }
}
