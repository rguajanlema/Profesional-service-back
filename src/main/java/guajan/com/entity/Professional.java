package guajan.com.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professional")
public class Professional {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfessional",nullable = false)
    private String id;

    private String name;
    private String address;
    private String profession;
    private boolean status;

    //need abilities
    private List<Ability> abilities;
    //need score
    private List<Score> scores;
    //need like
    private List<Like> likes;
    //need comments
    private List<Comment> comments;

}
