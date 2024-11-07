package controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import mappers.PriceMapper;
import org.openapitools.api.PricesApi;
import org.openapitools.model.PriceDetailsDTO;
import org.openapitools.model.ProductPriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ports.outgoing.PricesDatabasePort;

@RestController
public class PricesController implements PricesApi {

    @Autowired
    PricesDatabasePort pricesDatabasePort;

    @Autowired
    PriceMapper priceMapper;

    @Override
    public ResponseEntity< ProductPriceDTO > getProductPricesByDate(
            @Parameter( name = "productId", description = "", required = true, in = ParameterIn.PATH) @PathVariable( "productId" ) Integer productId,
            @NotNull @Parameter( name = "priceDetails", description = "", required = true, in = ParameterIn.QUERY) @Valid PriceDetailsDTO priceDetails ) {
        return new ResponseEntity< >( priceMapper.toProductPriceDTO(
                pricesDatabasePort.getPriceByProductIdAndChainAndDates(
                        priceMapper.toProductPriceVO( priceDetails ), productId ) ), HttpStatus.OK );
    }
}
