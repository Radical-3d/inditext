package repositories;

import configuration.PricesJpaConfig;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import models.PricesMo;
import models.ProductMo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ContextConfiguration(
        classes = { PricesJpaConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
class PricesJpaRepositoryTest {

    @Resource
    private PricesJpaRepository prices;

    @Test
    void testFindPricesWithDateProductAndChain_thenGetOk() {
        // given
        int chain = 1;
        int productId = 35455;
        OffsetDateTime date = OffsetDateTime.parse( "2020-06-14-10.00.00" );
        ProductMo expectedProduct = ProductMo.builder().id( productId ).name( "T-shirt" ).build();
        PricesMo expectedValue =
                PricesMo.builder().priceList( 1 ).brandId( chain ).startDate( OffsetDateTime.parse( "2020-06-14-00.00.00" ) )
                        .endDate( OffsetDateTime.parse( "2020-12-31-23.59.59" ) ).productMo( expectedProduct ).priority( 0 )
                        .price( new BigDecimal( "35.50" ) ).currency( "EUR" ).build();

        // when
        Optional< List< PricesMo > > response = prices.findAllByProductMoBrandIdAndDate( productId, chain, date );

        // then
        Assertions.assertTrue( response.isPresent());
        Assertions.assertEquals( 1, response.get().size() );
        Assertions.assertEquals( expectedValue, response.get().getFirst() );
    }
}
