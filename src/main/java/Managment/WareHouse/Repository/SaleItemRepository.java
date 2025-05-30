package Managment.WareHouse.Repository;

import Managment.WareHouse.Entity.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
}
