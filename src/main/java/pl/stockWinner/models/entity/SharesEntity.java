package pl.stockWinner.models.entity;

import javax.persistence.*;

@Entity
public class SharesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String ticker;

    @Column
    private Number volume;

    @Column
    private Number price;

    @Column
    private String date;

    public String getTicker() {
        return ticker;
    }

    public SharesEntity setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    public Number getVolume() {
        return volume;
    }

    public SharesEntity setVolume(Number volume) {
        this.volume = volume;
        return this;
    }

    public Number getPrice() {
        return price;
    }

    public SharesEntity setPrice(Number price) {
        this.price = price;
        return this;
    }

    public String getDate() {
        return date;
    }

    public SharesEntity setDate(String date) {
        this.date = date;
        return this;
    }
}
