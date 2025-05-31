package Managment.WareHouse.Service;


import Managment.WareHouse.DTO.SalesDTO;
import Managment.WareHouse.Entity.Sales;
import Managment.WareHouse.Repository.SalesRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    @Autowired
    private final SalesRepository salesRepository;
    private final GenericUtils genericUtils;
    private final ModelMapper modelMapper;

    public SalesService(SalesRepository salesRepository, GenericUtils genericUtils, ModelMapper modelMapper) {
        this.salesRepository = salesRepository;
        this.genericUtils = genericUtils;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public ResponseEntity<?> saveSale(SalesDTO salesDTO) {
        Sales sales = modelMapper.map(salesDTO, Sales.class);
        Sales savedSales = salesRepository.save(sales);
        return ResponseEntity.ok(modelMapper.map(savedSales, SalesDTO.class));
    }

    @Transactional
    public ResponseEntity<?> deleteSale(Long id) {
        if (genericUtils.saleExists(id)) {
            salesRepository.deleteById(id);
            return ResponseEntity.ok().body("Sale deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Sale does not exist");
        }
    }

    public ResponseEntity<SalesDTO> getSale(Long id) {

        //always present bc is the current sale
        Optional<Sales> sales = salesRepository.findById(id);

        SalesDTO salesDTO = modelMapper.map(sales.get(), SalesDTO.class);
        salesDTO.setSaleItemsDTO(genericUtils.getSaleItemDTOForSale(id));
        return ResponseEntity.ok(salesDTO);

    }

    public List<SalesDTO> getAllSales() {

        return salesRepository.findAll().stream()
                .map(sales -> modelMapper.map(sales, SalesDTO.class)).toList();
    }

}
