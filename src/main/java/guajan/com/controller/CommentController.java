package guajan.com.controller;

import guajan.com.entity.Comment;
import guajan.com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/list/{toComment}/{destinataryComment}")
    public ResponseEntity<List<Comment>>  list(@PathVariable String toComment, @PathVariable String destinataryComment){
        return new ResponseEntity<>(
                commentService.getCommentsOfMe(toComment, destinataryComment),
                null,
                HttpStatus.OK);
    }

    @GetMapping("/disable/{id}")
    public ResponseEntity<Comment> disable(@PathVariable Long id){
        return new ResponseEntity<>(commentService.disable(id),null,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Comment> save(@RequestBody Comment comment){
        return new ResponseEntity<>(commentService.save(comment),null,HttpStatus.CREATED);
    }
}
