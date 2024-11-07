package vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class ProductPriceVO {

    private int rate;

    private OffsetDateTime validFrom;

    private OffsetDateTime validUntil;

    private int product;

    private int chain;

    private BigDecimal price;

    private String currency;
}
