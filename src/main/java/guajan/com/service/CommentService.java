package guajan.com.service;

import guajan.com.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment save(Comment comment);
    List<Comment> getCommentsOfMe(String toComment, String destinataryComment);
    Comment disable(Long id);
}
