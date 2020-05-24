package ru.geekbrains.lesson;


import org.hibernate.cfg.Configuration;
import ru.geekbrains.lesson.persist.Contact;
import ru.geekbrains.lesson.persist.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // INSERT User
//        EntityManager em = emFactory.createEntityManager();
//        User user = new User(null, "ivan", "password");
//
//        em.getTransaction().begin();
//        em.persist(user);
//        em.getTransaction().commit();

        // SELECT User
//        EntityManager em = emFactory.createEntityManager();
//        User user = em.find(User.class, 1L);
//        System.out.println(user);

        // UPDATE User
//        EntityManager em = emFactory.createEntityManager();
//        User user = em.find(User.class, 1L);
//        System.out.println(user);
//
//        em.getTransaction().begin();
//        user.setName("Alexey");
//        em.getTransaction().commit();

        // DELETE User
//        EntityManager em = emFactory.createEntityManager();
//        User user = em.find(User.class, 2L);
//
//        em.getTransaction().begin();
//        em.remove(user);
//        em.getTransaction().commit();

        // SELECT BY NAME
        EntityManager em = emFactory.createEntityManager();

        //List<User> users = em.createQuery("from User u where u.name = :name", User.class)
        List<User> users = em.createNamedQuery("getByName", User.class) // аннотация в классе User
                .setParameter("name", "ivan")
                .getResultList();
        users.forEach(System.out::println);

        User user = users.get(0);
        em.getTransaction().begin();
        em.persist(new Contact(null, "phone", "123456789", user));
        em.persist(new Contact(null, "email", "123456789@gmail.com", user));
        em.persist(new Contact(null, "phone", "987654321", user));
        em.getTransaction().commit();

        em.refresh(user);

        System.out.println(user);
        em.close();

//        EntityManager em = emFactory.createEntityManager();
//        List<Object> resultList = em.createNamedQuery("withUserName")
//                .setParameter("id", 3L).getResultList();
//
//        resultList.forEach(System.out::println);

    }
}
