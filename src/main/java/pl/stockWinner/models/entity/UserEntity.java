package pl.stockWinner.models.entity;

import javax.persistence.*;

// TODO use lombok
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false, length = 50, unique = true)
    private String userMail;

    @Column(nullable=false, length = 100)
    private String password;

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
