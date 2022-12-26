package guajan.com.controller;

import guajan.com.entity.Ability;
import guajan.com.service.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ability")
public class AbiityController {

    @Autowired
    private AbilityService abilityService;

    @PostMapping("/save")
    public ResponseEntity<Ability> save(@RequestBody Ability ability){
        return new ResponseEntity<>(abilityService.save(ability),null, HttpStatus.CREATED);
    }

    @GetMapping("/disable/{id}")
    public ResponseEntity<Ability> disable(@PathVariable Long id){
        return new ResponseEntity<>(abilityService.disable(id),null,HttpStatus.OK);
    }

    @GetMapping("/list/{email}")
    public ResponseEntity<List<Ability>> list(@PathVariable String email){
        return new ResponseEntity<>(abilityService.list(email),null,HttpStatus.OK);
    }
}
