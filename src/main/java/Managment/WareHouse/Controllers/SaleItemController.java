package Managment.WareHouse.Controllers;

import Managment.WareHouse.DTO.SaleItemDTO;
import Managment.WareHouse.Service.SaleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saleItem")
public class SaleItemController {

    @Autowired
    private SaleItemService saleItemService;

    @GetMapping("/all")
    public List<SaleItemDTO> getAllSaleItems() {
        return saleItemService.getAllSaleItems();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getSaleItem(@PathVariable("id") Long id) {
        return saleItemService.getSaleItem(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveSaleItem(@RequestBody SaleItemDTO saleItemDTO) {
        return saleItemService.saveSaleItem(saleItemDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSaleItem(@PathVariable("id") Long id) {
        return saleItemService.deleteSaleItem(id);
    }
}
