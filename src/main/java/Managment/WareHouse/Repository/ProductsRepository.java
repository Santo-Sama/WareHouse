package Managment.WareHouse.Repository;

import Managment.WareHouse.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
