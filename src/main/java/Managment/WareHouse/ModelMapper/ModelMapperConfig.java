package Managment.WareHouse.ModelMapper;


import Managment.WareHouse.DTO.ProductsDTO;
import Managment.WareHouse.DTO.SaleItemDTO;
import Managment.WareHouse.DTO.SalesDTO;
import Managment.WareHouse.Entity.Products;
import Managment.WareHouse.Entity.SaleItem;
import Managment.WareHouse.Entity.Sales;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setSkipNullEnabled(true)
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        // create typemaps before implict mappings
        TypeMap<SaleItemDTO, SaleItem> salesItemDTOMapper = modelMapper.createTypeMap(SaleItemDTO.class, SaleItem.class).implicitMappings();
        TypeMap<SaleItem, SaleItemDTO> salesItemMapper = modelMapper.createTypeMap(SaleItem.class, SaleItemDTO.class);
        TypeMap<ProductsDTO, Products> productsDTOMapper = modelMapper.createTypeMap(ProductsDTO.class, Products.class);
        TypeMap<Products, ProductsDTO> productsMapper = modelMapper.createTypeMap(Products.class, ProductsDTO.class);
        TypeMap<SalesDTO, Sales> salesDTOMapper = modelMapper.createTypeMap(SalesDTO.class, Sales.class);
        TypeMap<Sales, SalesDTO> salesMapper = modelMapper.createTypeMap(Sales.class, SalesDTO.class);

        //SaleItem -> SaleItemDTO
        salesItemMapper
                .addMappings(mapper -> mapper.map(src -> src.getProduct().getId(), SaleItemDTO::setProduct_id))
                .addMappings(mapper -> mapper.map(src -> src.getSale().getId(), SaleItemDTO::setSale_id));

        //SaleItemDTO -> SaleItem
        salesItemDTOMapper
                .addMappings(mapper -> mapper.skip(SaleItem::setProduct))
                .addMappings(mapper -> mapper.skip(SaleItem::setSale));

        //Product -> ProductDTO
        productsMapper
                .addMappings(mapper -> mapper.map(src -> src.getWarehouse().getId(), ProductsDTO::setWarehouse_id));

        //ProductDTO -> Product
        productsDTOMapper
                .addMappings(mapper -> mapper.skip(Products::setWarehouse));

        //Sale -> SaleDTO
        salesMapper
                .addMappings(mapper -> mapper.map(src -> src.getCustomer().getId(), SalesDTO::setCustomer_id));

        //SaleDTO -> Sale
        salesDTOMapper
                .addMappings(mapper -> mapper.skip(Sales::setCustomer));

        return modelMapper;
    }
}
