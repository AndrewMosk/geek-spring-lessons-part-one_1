package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.persist.entity.User;
import ru.geekbrains.persist.repo.UserRepository;
import ru.geekbrains.persist.repo.UserSpecification;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repository.findAll();
    }

//    public Page<User> filterByAge(Integer minAge, Integer maxAge, Pageable pageable) {
//        if (minAge != 0 & maxAge == 0) {
//            return repository.findByAgeGreaterThanEqual(minAge, pageable);
//        } else if (minAge == 0 & maxAge != 0) {
//            return repository.findByAgeLessThanEqual(maxAge, pageable);
//        } else if (minAge != 0 & maxAge != 0) {
//            return repository.findByAgeBetween(minAge, maxAge, pageable);
//        }
//
//        return repository.findAll(pageable);
//    }

    public Page<User> filterByAge(Integer minAge, Integer maxAge, String name, Pageable pageable) {
        Specification<User> specification = UserSpecification.trueLiteral();

        if (minAge != null) {
            specification = specification.and(UserSpecification.ageGreaterThanOrEqual(minAge));
        }

        if (maxAge != null) {
            specification = specification.and(UserSpecification.ageLessThanOrEqual(maxAge));
        }

        if (name != null) {
            specification = specification.and(UserSpecification.findUserByName(name));
        }

        return repository.findAll(specification, pageable);
    }

    @Transactional
    public void save(User user) {
        repository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(long id) {
        return repository.findById(id);
    }
}
