package guajan.com.controller;

import guajan.com.entity.Server;
import guajan.com.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private ServerService serverService;

    @GetMapping("/list")
    public ResponseEntity<List<Server>> list(){
        return new ResponseEntity<>(serverService.getAll(),null, HttpStatus.OK);
    }
}
