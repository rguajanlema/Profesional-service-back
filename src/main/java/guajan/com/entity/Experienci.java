package guajan.com.entity;

import javax.persistence.*;

@Entity
@Table(name = "experienci")
public class Experienci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String key;
    private String text;


    public Experienci(){}
    public Experienci(String key, String text) {
        this.key = key;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}