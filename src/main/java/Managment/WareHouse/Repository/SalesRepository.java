package Managment.WareHouse.Repository;

import Managment.WareHouse.Entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Long> {
}
