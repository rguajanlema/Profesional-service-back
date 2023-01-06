package guajan.com.controller;

import guajan.com.entity.Server;
import guajan.com.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private ServerService serverService;

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        Map<String,Object> map = new LinkedHashMap<>();
        List<Server> getAllServer = serverService.getAll();

        if(!getAllServer.isEmpty()){
            map.put("code",HttpStatus.OK);
            map.put("data",getAllServer);

            return new ResponseEntity<>(map, HttpStatus.OK);
        }else{
            map.put("code", HttpStatus.NOT_FOUND);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/save")
    public ResponseEntity<Server> save(@RequestBody Server server){
        return new ResponseEntity<>(serverService.save(server),null,HttpStatus.CREATED);
    }
}
