package pl.stockWinner.models.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
public class Currency {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double rate;

    @Column(nullable = false)
    private Timestamp lastUpdate;

    public Currency(String name, double rate, Timestamp lastUpdate) {
        this.name = name;
        this.rate = rate;
        this.lastUpdate = lastUpdate;
    }
}
