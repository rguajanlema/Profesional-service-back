package guajan.com.service;

import guajan.com.entity.User;
import guajan.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
//        return userRepository.findAll().
//                stream().
//                filter(user->
//                        user.isState()==true).
//                toList();

        return userRepository.findAllByState(true);
    }

    @Override
    public User getByUserId(Long id) {
        User resp = userRepository.findById(id).orElse(null);
        return resp;
    }

    @Override
    public User saveUser(User entity) {
        entity.setState(true);
        entity.setCreatedAt(new Date());
        entity.setModifidDate(new Date());

        return userRepository.save(entity);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
//        Stream<User> user = userRepository.findAll().
//                stream().
//                filter(
//                        userIndex ->
//                        userIndex.getEmail().equals(email) &&
//                                userIndex.getPassword().equals(password));
//
//        User resp = user.findFirst().orElse(null);
//        return resp;

        return  userRepository.findByEmailAndPassword(email,password).stream().findFirst().orElseThrow(null);
    }

    @Override
    public User updateAllData(User user, Long id) {
        User userFind = userRepository.findById(id).orElse(null);
        if (userFind == null)
            return null;

        userFind.setId(id);
        userFind.setEmail(user.getEmail());
        userFind.setPassword(user.getPassword());
        userFind.setModifidDate(new Date());
        return userRepository.save(userFind);
    }

    @Override
    public User changeState(Long id) {
        User userFind = userRepository.findById(id).orElse(null);
        if (userFind == null)
            return null;

        userFind.setState(!userFind.isState());
        return userRepository.save(userFind);
    }
}
