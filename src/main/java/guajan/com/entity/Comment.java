package guajan.com.entity;

import javax.persistence.*;

@Entity(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcomment", nullable = false)
    private Long id;

    @Column(name = "tocomment")
    private String toComment;
    @Column(name = "textcomment")
    private String textComment;
    @Column(name = "destinatarycomment")
    private String destinataryComment;
    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToComment() {
        return toComment;
    }

    public void setToComment(String toComment) {
        this.toComment = toComment;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public String getDestinataryComment() {
        return destinataryComment;
    }

    public void setDestinataryComment(String destinataryComment) {
        this.destinataryComment = destinataryComment;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
