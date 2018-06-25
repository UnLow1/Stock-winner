package pl.stockWinner.models.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class CurrencyPersonalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "user_id"))
    private UserEntity userEntity;

    // TODO use this commented annotations
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "currency_id"))
    @Column
    private long currencyEntityId;

    @Column
    private Double rate;

    @Column
    private Double amount;
}
