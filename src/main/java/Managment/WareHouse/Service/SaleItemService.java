package Managment.WareHouse.Service;

import Managment.WareHouse.DTO.SaleItemDTO;
import Managment.WareHouse.Entity.SaleItem;
import Managment.WareHouse.Repository.SaleItemRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleItemService {

    @Autowired
    private final SaleItemRepository saleItemRepository;
    private final GenericUtils genericUtils;
    private final ModelMapper modelMapper;

    public SaleItemService(SaleItemRepository saleItemRepository,ModelMapper  modelMapper  , GenericUtils genericUtils) {
        this.genericUtils = genericUtils;
        this.modelMapper = modelMapper;
        this.saleItemRepository = saleItemRepository;
    }

    @Transactional
    public ResponseEntity<?> saveSaleItem(SaleItemDTO saleItemDTO) {
        if (genericUtils.productExists(saleItemDTO.getProduct_id())) {
            if (genericUtils.saleExists(saleItemDTO.getSale_id())) {
                SaleItem saleItem = modelMapper.map(saleItemDTO, SaleItem.class);

                saleItem.setSale(genericUtils.getSale(saleItemDTO.getSale_id()));
                saleItem.setProduct(genericUtils.getProduct(saleItemDTO.getProduct_id()));

                SaleItem saleItemSaved = saleItemRepository.save(saleItem);

                return ResponseEntity.ok(modelMapper.map(saleItemSaved, SaleItemDTO.class));
            }else {
                return ResponseEntity.badRequest().body("Sale does not exist");
            }
        }else {
            return ResponseEntity.badRequest().body("Product does not exist");
        }
    }

    @Transactional
    public ResponseEntity<?> deleteSaleItem(Long id) {
        if (genericUtils.saleItemExists(id)) {
            saleItemRepository.deleteById(id);
            return ResponseEntity.ok().body("SaleItem deleted successfully");
        }else {
            return ResponseEntity.badRequest().body("SaleItem does not exist");
        }
    }

    public List<SaleItemDTO> getAllSaleItems() {
        return saleItemRepository.findAll().stream()
                .map(saleItem -> modelMapper.map(saleItem, SaleItemDTO.class)).toList();
    }

    public ResponseEntity<?> getSaleItem(Long id) {
        if (genericUtils.saleItemExists(id)) {
            SaleItem saleItem = saleItemRepository.findById(id).get();
            return ResponseEntity.ok(modelMapper.map(saleItem, SaleItemDTO.class));
        }else {
            return ResponseEntity.badRequest().body("SaleItem does not exist");
        }
    }
}
