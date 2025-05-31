package Managment.WareHouse.Service;


import Managment.WareHouse.DTO.WareHouseDTO;
import Managment.WareHouse.Entity.WareHouse;
import Managment.WareHouse.Repository.WareHouseRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WareHouseService {

    private final WareHouseRepository wareHouseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public WareHouseService(WareHouseRepository wareHouseRepository , ModelMapper modelMapper) {
        this.wareHouseRepository = wareHouseRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public WareHouseDTO saveWareHouse(WareHouseDTO wareHouseDTO) {
        WareHouse wareHouse = modelMapper.map(wareHouseDTO, WareHouse.class);
        WareHouse savedWareHouse = wareHouseRepository.save(wareHouse);
        return modelMapper.map(savedWareHouse, WareHouseDTO.class);
    }

    @Transactional
    public ResponseEntity<String> deleteWareHouse(Long id) {
        if (wareHouseRepository.existsById(id)) {
            wareHouseRepository.deleteById(id);
            return ResponseEntity.ok().body("WareHouse deleted successfully"); }
        else {
            return ResponseEntity.notFound().build();
        }
    }



    public List<WareHouseDTO> getAllWareHouse() {
        return wareHouseRepository.findAll().stream()
                .map(wareHouse -> modelMapper.map(wareHouse, WareHouseDTO.class)).toList();
    }

    // WareHouseDTO
    public ResponseEntity<WareHouseDTO> getWareHouse(Long id) {

        Optional<WareHouse> wareHouse = wareHouseRepository.findById(id);
        if (wareHouse.isPresent()) {
            return ResponseEntity.ok().body(modelMapper.map(wareHouse.get(), WareHouseDTO.class));
        }
        return ResponseEntity.notFound().build();
    }
}
