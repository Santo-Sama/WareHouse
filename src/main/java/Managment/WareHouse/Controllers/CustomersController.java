package Managment.WareHouse.Controllers;

import Managment.WareHouse.DTO.CustomersDTO;
import Managment.WareHouse.Service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @GetMapping("/all")
    public List<CustomersDTO> getAllCustomers() {
        return customersService.getAllCustomers();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable("id") Long id) {
        return customersService.getCustomer(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomersDTO customersDTO) {
        return customersService.saveCustomer(customersDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
        return customersService.deleteCustomer(id);
    }
}
