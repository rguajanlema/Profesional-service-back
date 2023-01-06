package guajan.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "like")
public class Like {
    @Id
    @Column(name = "idLike", nullable = false)
    private Long id;
    private boolean status;
    private String key;
}
