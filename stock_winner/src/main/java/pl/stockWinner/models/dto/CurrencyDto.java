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
}
