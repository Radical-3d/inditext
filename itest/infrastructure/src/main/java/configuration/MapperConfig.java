package configuration;

import mappers.PriceMapper;
import mappers.PriceMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    PriceMapper priceMapper() { return new PriceMapperImpl(); }
}
