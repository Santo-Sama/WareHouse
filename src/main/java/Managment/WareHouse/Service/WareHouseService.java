package Managment.WareHouse.Service;


import Managment.WareHouse.DTO.WareHouseDTO;
import Managment.WareHouse.Entity.WareHouse;
import Managment.WareHouse.Repository.WareHouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<WareHouseDTO> getAllWareHouse() {
        return wareHouseRepository.findAll().stream().map(wareHouse -> modelMapper.map(wareHouse, WareHouseDTO.class)).toList();} //

    // WareHouseDTO
    public Optional<WareHouseDTO> getWareHouse(Long id) {
        return wareHouseRepository.findById(id).map(wareHouse -> modelMapper.map(wareHouse, WareHouseDTO.class));
    }
}
