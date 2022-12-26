package guajan.com.repository;

import guajan.com.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {

   // @Query("select u from User u where u.email = :email and u.password = :password")
   // User findByEmailAndPassword(String email, String password);
}
