package models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * Persistence class for the prices table.
 */
@Data
@Builder
@Table( name = "prices" )
public class PricesMo implements Serializable {

    @Serial
    private static final long serialVersionUID = -2861930835633934325L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "price_list", unique = true, nullable = false )
    private int priceList;

    @Column( name = "brand_id", nullable = false )
    private int brandId;

    @Column( name = "start_date" )
    private OffsetDateTime startDate;

    @Column( name = "end_date" )
    private OffsetDateTime endDate;

    @ManyToOne
    @JoinColumn( name = "prouct_id", nullable = false )
    private ProductMo productMo;

    @Column( name = "priority", nullable = false )
    private int priority;

    @Column( name = "price", nullable = false )
    private BigDecimal price;

    @Column( name = "curr" )
    private String currency;

}
