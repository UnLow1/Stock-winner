package pl.stockWinner.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SharesDTO {
    private Long id;

    @JsonProperty
    @NotNull
    @Size(max = 255)
    private String ticker;

    @JsonProperty
    @NotNull
    @Size(max = 255)
    private Number volume;

    @JsonProperty
    @NotNull
    @Size(max = 255)
    private Number price;

    @JsonProperty
    @NotNull
    @Size(max = 255)
    private String date;

    public String getTicker() {
        return ticker;
    }

    public SharesDTO setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    public Number getVolume() {
        return volume;
    }

    public SharesDTO setVolume(Number volume) {
        this.volume = volume;
        return this;
    }

    public Number getPrice() {
        return price;
    }

    public SharesDTO setPrice(Number price) {
        this.price = price;
        return this;
    }

    public String getDate() {
        return date;
    }

    public SharesDTO setDate(String date) {
        this.date = date;
        return this;
    }
}
