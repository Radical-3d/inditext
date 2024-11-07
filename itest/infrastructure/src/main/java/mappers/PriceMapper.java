package mappers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import models.PricesMo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.openapitools.model.PriceDetailsDTO;
import org.openapitools.model.ProductPriceDTO;
import vo.PriceDetailsVO;
import vo.ProductPriceVO;

import java.time.format.DateTimeFormatter;

@Mapper( componentModel = MappingConstants.ComponentModel.SPRING, imports = DateTimeFormatter.class )
public interface PriceMapper {

    @Mapping( target = "rate", source = "priceList" )
    @Mapping( target = "validFrom", source = "startDate" )
    @Mapping( target = "validUntil", source = "endDate" )
    @Mapping( target = "product", expression = "java( pricesMo.getProductMo().getId() )" )
    @Mapping( target = "chain", source = "brandId" )
    ProductPriceVO toProductPriceVO ( PricesMo pricesMo );

    PriceDetailsVO toProductPriceVO( @NotNull @Valid PriceDetailsDTO priceDetails );

    @Mapping( target = "priceId", source = "rate" )
    @Mapping( target = "validFrom", expression = "java( priceByProductIdAndChainAndDates.getValidFrom()." +
            "format( DateTimeFormatter.ofPattern(\"yyy-MM-dd-HH.mm.ss\") ) )" )
    @Mapping( target = "validUntil", expression = "java(  priceByProductIdAndChainAndDates.getValidUntil()" +
            ".format( DateTimeFormatter.ofPattern(\"yyy-MM-dd-HH.mm.ss\") ) )" )
    ProductPriceDTO toProductPriceDTO( ProductPriceVO priceByProductIdAndChainAndDates );
}
