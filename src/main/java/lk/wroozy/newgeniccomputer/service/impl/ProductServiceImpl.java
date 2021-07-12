package lk.wroozy.newgeniccomputer.service.impl;

import lk.wroozy.newgeniccomputer.dto.ProductVariationDTO;
import lk.wroozy.newgeniccomputer.dto.request.ProductRequestDTO;
import lk.wroozy.newgeniccomputer.entity.CategoryEntity;
import lk.wroozy.newgeniccomputer.entity.ProductDetailEntity;
import lk.wroozy.newgeniccomputer.entity.ProductEntity;
import lk.wroozy.newgeniccomputer.exception.CustomException;
import lk.wroozy.newgeniccomputer.repository.CategoryRepository;
import lk.wroozy.newgeniccomputer.repository.ProductDetailRepository;
import lk.wroozy.newgeniccomputer.repository.ProductRepository;
import lk.wroozy.newgeniccomputer.service.ProductService;
import lk.wroozy.newgeniccomputer.util.DateConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductDetailRepository productDetailRepository;
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              ProductDetailRepository productDetailRepository,
                              CategoryRepository categoryRepository,
                              ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.productDetailRepository = productDetailRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<?> addProduct(ProductRequestDTO productRequestDTO) {
        try{
            if (productRequestDTO == null)
                return new ResponseEntity<>("Product details not found", HttpStatus.NOT_FOUND);
            List<ProductDetailEntity> productDetailList = new ArrayList<>();
            Optional<CategoryEntity> categoryEntity = categoryRepository.findById(productRequestDTO.getCategoryId());
            if (categoryEntity.isEmpty())
                return new ResponseEntity<>("Category not found",HttpStatus.NOT_FOUND);

            ProductEntity productEntity = modelMapper.map(productRequestDTO, ProductEntity.class);
            productEntity.setCategoryEntity(categoryEntity.get());

            ProductEntity product = productRepository.save(productEntity);
            if (product == null)
                return new ResponseEntity<>("Product not saved",HttpStatus.BAD_REQUEST);
            for (ProductVariationDTO variationDTO :
                    productRequestDTO.getVariationList()) {
                ProductDetailEntity productDetailEntity = modelMapper.map(variationDTO, ProductDetailEntity.class);
                productDetailEntity.setUpdateDate(DateConverter.localDateToSql(LocalDate.now()));
                productDetailEntity.setUpdateTime(DateConverter.localTimeToSql(LocalTime.now()));
                productDetailEntity.setProductEntity(product);

                productDetailRepository.save(productDetailEntity);
            }
            return new ResponseEntity<>("Product save to system",HttpStatus.OK);
        }catch (Exception e){
            throw new CustomException("Failed to add product : "+e.getMessage());
        }
    }
}
