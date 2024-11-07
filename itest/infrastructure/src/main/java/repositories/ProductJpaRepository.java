package repositories;

import models.ProductMo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository  extends JpaRepository< ProductMo, Integer > {
}
