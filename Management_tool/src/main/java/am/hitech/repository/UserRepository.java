package am.hitech.repository;

import am.hitech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(int id);

    List<User> findAllBy();

    boolean existsByEmail(String email);

    User findByEmail(String email);
}
