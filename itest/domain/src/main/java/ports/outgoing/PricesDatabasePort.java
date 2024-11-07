package ports.outgoing;

import vo.PriceDetailsVO;
import vo.ProductPriceVO;

public interface PricesDatabasePort {

    ProductPriceVO getPriceByProductIdAndChainAndDates( PriceDetailsVO priceDetailsVO, Integer productId );
}
