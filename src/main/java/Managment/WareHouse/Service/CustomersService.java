package Managment.WareHouse.Service;

import Managment.WareHouse.DTO.CustomersDTO;
import Managment.WareHouse.Entity.Customers;
import Managment.WareHouse.Repository.CustomersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {

    @Autowired
    private final CustomersRepository customersRepository;
    private final GenericUtils genericUtils;
    private final ModelMapper modelMapper;

    public CustomersService(ModelMapper modelMapper,CustomersRepository customersRepository, GenericUtils genericUtils) {
        this.customersRepository = customersRepository;
        this.modelMapper = modelMapper;
        this.genericUtils = genericUtils;
    }

    public ResponseEntity<CustomersDTO> saveCustomer(CustomersDTO customersDTO) {
        Customers customers = modelMapper.map(customersDTO, Customers.class);

        Customers savedCustomers = customersRepository.save(customers);
        return ResponseEntity.ok(modelMapper.map(savedCustomers, CustomersDTO.class));
    }

    public ResponseEntity<?> deleteCustomer(Long id) {
        if (customersRepository.existsById(id)) {
            customersRepository.deleteById(id);
            return ResponseEntity.ok("Customer deleted");
        } else {
            return ResponseEntity.badRequest().body("Customer not found");
        }
    }

    public ResponseEntity<?> getCustomer(Long id) {
        if (customersRepository.existsById(id)) {
            Customers customers = customersRepository.findById(id).get();
            return ResponseEntity.ok(modelMapper.map(customers, CustomersDTO.class));
        } else {
            return ResponseEntity.badRequest().body("Customer not found");
        }
    }

    public List<CustomersDTO> getAllCustomers() {
        return customersRepository.findAll().stream(
            ).map(customers -> modelMapper.map(customers, CustomersDTO.class)).toList();
    }
}
