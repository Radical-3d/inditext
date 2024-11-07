package repositories;

import models.PricesMo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PricesJpaRepository extends JpaRepository< PricesMo, Integer > {

    @Query( "SELECT PricesMo FROM PricesMo p LEFT JOIN ProductMo pr ON p.productMo.id = pr.id " +
            "WHERE p.productMo.id = :productId AND " +
            "p.brandId = :chain AND " +
            "p.startDate <= :validationDate AND " +
            ":validationDate <= p.endDate" )
    Optional< List< PricesMo > > findAllByProductMoBrandIdAndDate( @Param( "productId" ) int productId, @Param( "chain" ) int chain,
            @Param( "validationDate" ) OffsetDateTime validationDate );
}
