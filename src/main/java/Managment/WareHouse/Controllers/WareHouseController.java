package Managment.WareHouse.Controllers;

import Managment.WareHouse.DTO.WareHouseDTO;
import Managment.WareHouse.Service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/warehouse")
public class WareHouseController {

    @Autowired
    private WareHouseService wareHouseService;

    @GetMapping("/all")
    public List<WareHouseDTO> getAllWareHouse() {
        return wareHouseService.getAllWareHouse();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<WareHouseDTO> getWareHouse(@PathVariable("id") Long id) {
        return wareHouseService.getWareHouse(id);
    }

    @PostMapping("/save")
    public WareHouseDTO saveWareHouse(@RequestBody WareHouseDTO wareHouseDTO) {
        return wareHouseService.saveWareHouse(wareHouseDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteWareHouse(@PathVariable("id") Long id) {
        wareHouseService.deleteWareHouse(id);
    }
}
