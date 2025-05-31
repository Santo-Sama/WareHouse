package Managment.WareHouse.Controllers;

import Managment.WareHouse.DTO.SalesDTO;
import Managment.WareHouse.Service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping("/all")
    public List<SalesDTO> getAllSales() {
        return salesService.getAllSales();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SalesDTO> getSale(@PathVariable("id") Long id) {
        return salesService.getSale(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveSale(@RequestBody SalesDTO salesDTO) {
        return salesService.saveSale(salesDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSale(@PathVariable("id") Long id) {
        return salesService.deleteSale(id);
    }

}
