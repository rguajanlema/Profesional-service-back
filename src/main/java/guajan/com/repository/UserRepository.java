package guajan.com.repository;

import guajan.com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {

    @Query(value = "SELECT u FROM users u WHERE u.state = :state")
    List<User> findAllByState(@Param("state") boolean state);
   @Query(value = "SELECT u FROM users u WHERE u.email = :email and u.password = :password")
    List<User> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
