package ru.geekbrains.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.persist.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    List<User> findByAgeGreaterThan(Integer age);

    List<User> findByAgeBetween(Integer minAge, Integer maxAge);

    List<User> findByAgeLessThan(Integer age);
}
