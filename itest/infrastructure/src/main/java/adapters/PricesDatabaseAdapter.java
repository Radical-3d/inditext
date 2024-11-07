package adapters;

import mappers.PriceMapper;
import models.PricesMo;
import org.springframework.beans.factory.annotation.Autowired;
import ports.outgoing.PricesDatabasePort;
import repositories.PricesJpaRepository;
import vo.PriceDetailsVO;
import vo.ProductPriceVO;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class PricesDatabaseAdapter implements PricesDatabasePort {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private PricesJpaRepository pricesJpaRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private PriceMapper priceMapper;

    @Override
    public ProductPriceVO getPriceByProductIdAndChainAndDates( PriceDetailsVO priceDetailsVO, Integer productId ) {

        Optional< List< PricesMo > > optionalListOfPrices = pricesJpaRepository.findAllByProductMoBrandIdAndDate( productId, priceDetailsVO.getChain(),
                OffsetDateTime.parse( priceDetailsVO.getValidationDate() ) );

        if ( optionalListOfPrices.isPresent() ) {
            return  filterThePriceByPriority( optionalListOfPrices.orElseGet( ArrayList::new ) );
        }
        return null;
    }

    private ProductPriceVO filterThePriceByPriority( List< PricesMo > pricesMoList ) {

        return priceMapper.toProductPriceVO( pricesMoList.stream().max( Comparator.comparing( PricesMo::getPriority ) )
                .orElseThrow( NoSuchElementException::new) );
    }
}
