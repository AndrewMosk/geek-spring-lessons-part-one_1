package ru.geekbrains.persist.repo;

import org.springframework.stereotype.Repository;
import ru.geekbrains.persist.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager em;

    // выборка всех пользователей. на сколько я понимаю, если понадобится еще какая-то, нужно будет добавить метод с новым запросом
    public List<User> findAll() {
        return em.createQuery("from User", User.class).getResultList();
    }

    public void save(User user) {
        em.persist(user);
    }

    public User findById(long id) {
        return em.find(User.class, id);
    }
}
