package Managment.WareHouse.Service;

import Managment.WareHouse.DTO.SaleItemDTO;
import Managment.WareHouse.Entity.Products;
import Managment.WareHouse.Entity.SaleItem;
import Managment.WareHouse.Entity.Sales;
import Managment.WareHouse.Entity.WareHouse;
import Managment.WareHouse.Repository.ProductsRepository;
import Managment.WareHouse.Repository.SaleItemRepository;
import Managment.WareHouse.Repository.SalesRepository;
import Managment.WareHouse.Repository.WareHouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericUtils {

    private final ProductsRepository productsRepository;
    private final WareHouseRepository wareHouseRepository;
    private final SaleItemRepository saleItemRepository;
    private final SalesRepository salesRepository;
    private final ModelMapper modelMapper;

    public GenericUtils( SalesRepository salesRepository,SaleItemRepository saleItemRepository,ProductsRepository productsRepository , ModelMapper modelMapper , WareHouseRepository wareHouseRepository) {
        this.modelMapper = modelMapper;
        this.salesRepository = salesRepository;
        this.saleItemRepository = saleItemRepository;
        this.productsRepository = productsRepository;
        this.wareHouseRepository = wareHouseRepository;
    }

    public boolean productExists(Long Id) {
        return productsRepository.existsById(Id);
    }

    public Products getProduct(Long Id) {
        return productsRepository.findById(Id).get();
    }

    public boolean saleExists(Long Id) {
        return salesRepository.existsById(Id);
    }

   public Sales getSale(Long Id) {
       return salesRepository.findById(Id).get();
   }

   public List<SaleItemDTO> getSaleItemDTOForSale(Long Id) {
       List<SaleItem> saleItems = saleItemRepository.findBySaleId(Id);
       return saleItems.stream().map(saleItem -> modelMapper.map(saleItem, SaleItemDTO.class)).toList();

   }
    public boolean warehouseExists(Long Id) {
        return wareHouseRepository.existsById(Id);
    }

    public WareHouse getWareHouse(Long Id) {
        return wareHouseRepository.findById(Id).get();
    }

    public boolean saleItemExists(Long Id) {
        return saleItemRepository.existsById(Id);
    }

    public SaleItem getSaleItem(Long Id) {
        return saleItemRepository.findById(Id).get();
    }
}
