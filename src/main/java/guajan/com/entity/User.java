package guajan.com.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser", nullable = false)
    private Long id;

    String email;
    String password;
    boolean state;
    @Column(name = "created_at")
    Date createdAt;
    @Column(name = "modifid_date")
    Date modifidDate;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifidDate() {
        return modifidDate;
    }

    public void setModifidDate(Date modifidDate) {
        this.modifidDate = modifidDate;
    }
}
