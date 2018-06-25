package pl.stockWinner.models.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CurrencyPersonalDto {
    private Long id;

    @NotNull
    @Size(min = 3, max = 3)
    private String name;

    @NotNull
    private Number amount;

    @NotNull
    private Number rate;

    @NotNull
    private Number basePrice;

    @NotNull
    private Number currentPrice;

    @NotNull
    private Number value;
}
