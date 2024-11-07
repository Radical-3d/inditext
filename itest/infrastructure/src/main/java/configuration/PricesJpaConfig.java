package configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Objects;

@Configuration
@EnableJpaRepositories( basePackages = "repositories" )
@PropertySource( "persistence-prices.properties" )
@EnableTransactionManagement
public class PricesJpaConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource( ) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName( Objects.requireNonNull( env.getProperty( "spring.datasource.driver-class-name" ) ) );
        dataSource.setUrl( env.getProperty("spring.datasource.url" ) );
        dataSource.setUsername( env.getProperty("spring.jpa.user" ) );
        dataSource.setPassword( env.getProperty("spring.jpa.pass" ) );

        return dataSource;
    }
}
