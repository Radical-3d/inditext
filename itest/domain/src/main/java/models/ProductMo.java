package models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * Persistence class for the prices table.
 */
@Data
@Builder
@Table( name = "product" )
public class ProductMo implements Serializable {

    @Serial
    private static final long serialVersionUID = 6827134415197594943L;

    @Id
    @Column( name = "id", unique = true, nullable = false )
    private int id;

    @Column( name = "name", nullable = false )
    private String name;
}
