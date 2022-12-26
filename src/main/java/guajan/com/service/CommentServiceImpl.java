package guajan.com.service;

import guajan.com.entity.Comment;
import guajan.com.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsOfMe(String toComment, String destinataryComment) {
        List<Comment> commentList = commentRepository.
                findAll().
                stream().
                filter(
                        comment ->
                                comment.getToComment().equals(toComment) &&
                                comment.getDestinataryComment().equals(destinataryComment) &&
                                comment.isStatus()==true).
                toList();

        if(commentList.size()==0)
            return null;
        return commentList;
    }

    @Override
    public Comment disable(Long id) {
        Comment commentFind = commentRepository.findById(id).orElse(null);
        commentFind.setStatus(false);
        return commentRepository.save(commentFind);
    }
}
