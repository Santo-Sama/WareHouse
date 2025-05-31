package Managment.WareHouse.Controllers;

import Managment.WareHouse.DTO.ProductsDTO;
import Managment.WareHouse.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/all")
    public List<ProductsDTO> getAllProducts() {
        return productsService.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductsDTO> getProductById(@PathVariable("id") Long id) {
        return productsService.getProductById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody ProductsDTO productsDTO) {
        return productsService.saveProduct(productsDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        return productsService.deleteProduct(id);
    }
}
