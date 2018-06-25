package pl.stockWinner.models.entity;

import javax.persistence.*;

// TODO use lombok
@Entity
public class SharesPersonalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "user_id"))
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "shares_id"))
    private SharesEntity sharesEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public SharesEntity getSharesEntity() {
        return sharesEntity;
    }

    public void setSharesEntity(SharesEntity sharesEntity) {
        this.sharesEntity = sharesEntity;
    }

    public long getId() {
        return id;
    }

    public SharesPersonalEntity setId(long id) {
        this.id = id;
        return this;
    }
}
