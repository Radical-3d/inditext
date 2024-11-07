package configuration;

import adapters.PricesDatabaseAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ports.outgoing.PricesDatabasePort;

@Configuration
public class PortConfig {

    @Bean PricesDatabasePort pricesDatabasePort() { return new PricesDatabaseAdapter(); }
}
