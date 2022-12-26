package guajan.com.service;

import guajan.com.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getByUserId(Long id);
    User saveUser(User entity);
    User findByEmailAndPassword(String email, String password);
    User updateAllData(User user, Long id);
    User changeState(Long id);
}
