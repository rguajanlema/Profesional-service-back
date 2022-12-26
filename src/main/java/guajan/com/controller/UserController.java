package guajan.com.controller;

import guajan.com.entity.User;
import guajan.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> list(){
        return new ResponseEntity<>(userService.getAllUser(),null,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user){
        return new ResponseEntity<User>(userService.saveUser(user),null, HttpStatus.CREATED) ;
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getByUserId(id),null,HttpStatus.OK);
    }

    @GetMapping("/findByEmailAndPassword/{email}/{password}")
    public ResponseEntity<User> findByEmailAndPassword(@PathVariable String email, @PathVariable String password){
        return new ResponseEntity<>(userService.findByEmailAndPassword(email,password),null,HttpStatus.OK);
    }

    @PutMapping("/updateAllData/{id}")
    public ResponseEntity<User> updateAllData(@RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<>(userService.updateAllData(user,id),null,HttpStatus.OK);
    }
}
