package pl.stockWinner.models.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
public class CurrencyDto {
    @NotNull
    private Long id;

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    private double rate;

    @NotNull
    private Timestamp lastUpdate;

    public CurrencyDto(String name, double rate, Timestamp lastUpdate) {
        this.name = name;
        this.rate = rate;
        this.lastUpdate = lastUpdate;
    }

    public CurrencyDto() {}
}
