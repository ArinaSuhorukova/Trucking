package by.itechart.server.repository;

import by.itechart.server.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

    Page<User> findAll(Pageable pageable);

    Optional<User> findByLoginOrEmail(String login, String email);

    boolean existsByLogin(String login);

    boolean existsByEmail(String email);

    User findByEmailIgnoreCase(String email);
}
