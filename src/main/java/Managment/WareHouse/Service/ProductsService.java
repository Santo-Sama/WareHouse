package Managment.WareHouse.Service;

import Managment.WareHouse.DTO.ProductsDTO;
import Managment.WareHouse.Entity.Products;
import Managment.WareHouse.Repository.ProductsRepository;
import Managment.WareHouse.Repository.WareHouseRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;
    private final ModelMapper modelMapper;
    private final GenericUtils genericUtils;

    @Autowired
    public ProductsService(ProductsRepository productsRepository , ModelMapper modelMapper , GenericUtils genericUtils) {
        this.productsRepository = productsRepository;
        this.modelMapper = modelMapper;
        this.genericUtils = genericUtils;
    }

    @Transactional
    public ResponseEntity<?> saveProduct(ProductsDTO productsDTO) {
        if (genericUtils.warehouseExists(productsDTO.getWarehouse_id())) {
            Products products = modelMapper.map(productsDTO, Products.class);

            products.setWarehouse(genericUtils.getWareHouse(productsDTO.getWarehouse_id()));

            Products savedProducts = productsRepository.save(products);
            return ResponseEntity.ok(modelMapper.map(savedProducts, ProductsDTO.class));
        }
        else return ResponseEntity.badRequest().body("warehouse not found");
    }

    @Transactional
    public ResponseEntity<?> deleteProduct(Long id) {
        if (productsRepository.existsById(id)) {
            productsRepository.deleteById(id);
            return ResponseEntity.ok().body("Product deleted successfully");
        }
        else return ResponseEntity.badRequest().body("Product does not exist");
    }

    public List<ProductsDTO> getAllProducts() {
        return productsRepository.findAll().stream()
                .map(products -> modelMapper.map(products, ProductsDTO.class)).toList();
    }

    public ResponseEntity<ProductsDTO> getProductById(Long id) {

        if (genericUtils.productExists(id)) {
            Optional<Products> products = productsRepository.findById(id);
            return ResponseEntity.ok(modelMapper.map(products.get(), ProductsDTO.class));
        }
        return ResponseEntity.notFound().build();
    }
}
