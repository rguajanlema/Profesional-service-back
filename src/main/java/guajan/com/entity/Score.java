package guajan.com.entity;

import javax.persistence.*;

@Entity
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idScore", nullable = false)
    private Long id;

    private String key;
    private boolean status;
}
