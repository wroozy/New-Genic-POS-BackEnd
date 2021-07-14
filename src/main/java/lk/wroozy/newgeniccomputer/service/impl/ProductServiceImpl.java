package lk.wroozy.newgeniccomputer.service.impl;

import lk.wroozy.newgeniccomputer.dto.request.ProductUpdateRequestDTO;
import lk.wroozy.newgeniccomputer.dto.request.ProductUpdateVariationDTO;
import lk.wroozy.newgeniccomputer.dto.request.ProductVariationDTO;
import lk.wroozy.newgeniccomputer.dto.request.ProductRequestDTO;
import lk.wroozy.newgeniccomputer.dto.response.CategoryResponseDTO;
import lk.wroozy.newgeniccomputer.dto.response.ProductDetailResponseDTO;
import lk.wroozy.newgeniccomputer.dto.response.ProductResponseDTO;
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

    @Override
    public ResponseEntity<?> getAllProducts() {
        try{
            List<ProductEntity> all = productRepository.findAll();
            if(all.isEmpty())
                return new ResponseEntity<>("No product found",HttpStatus.NOT_FOUND);

            List<ProductResponseDTO> responseList = new ArrayList<>();
            for (ProductEntity productEntity :
                    all) {
                responseList.add(setProductResponse(productEntity));
            }
            return new ResponseEntity<>(responseList,HttpStatus.OK);
        }catch (Exception e){
            throw new CustomException("Failed to Fetch products : "+e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getProduct(long productId) {
        try{
            if (productId == 0)
                return new ResponseEntity<>("Product id not found",HttpStatus.NOT_FOUND);

            Optional<ProductEntity> productEntity = productRepository.findById(productId);
            if (productEntity.isEmpty())
                return new ResponseEntity<>("No product found",HttpStatus.NOT_FOUND);

            ProductResponseDTO productResponseDTO = setProductResponse(productEntity.get());
            return new ResponseEntity<>(productResponseDTO,HttpStatus.OK);

        }catch (Exception e){
            throw new CustomException("Failed to fetch product : "+e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> updateProduct(ProductUpdateRequestDTO productRequestDTO, long productId) {
        try{
            if (productRequestDTO == null && productId == 0)
                return new ResponseEntity<>("Product Id or product details not found",HttpStatus.BAD_REQUEST);

            Optional<ProductEntity> product = productRepository.findById(productId);
            if (product.isEmpty())
                return new ResponseEntity<>("Product not found",HttpStatus.BAD_REQUEST);

            ProductEntity productEntity = modelMapper.map(productRequestDTO, ProductEntity.class);
            productEntity.setProductId(productId);
            productEntity.setCategoryEntity(product.get().getCategoryEntity());
            ProductEntity updatedProduct = productRepository.save(productEntity);

            for (ProductUpdateVariationDTO variationDTO :
                    productRequestDTO.getVariationList()) {
                ProductDetailEntity productDetailEntity = modelMapper.map(variationDTO, ProductDetailEntity.class);
                if (variationDTO.isUpdated()){
                    productDetailEntity.setUpdateDate(DateConverter.localDateToSql(LocalDate.now()));
                    productDetailEntity.setUpdateTime(DateConverter.localTimeToSql(LocalTime.now()));
                    productDetailEntity.setProductEntity(updatedProduct);
                    productDetailRepository.save(productDetailEntity);
                }
            }

            return new ResponseEntity<>("Product updated",HttpStatus.OK);

        }catch (Exception e){
            throw new CustomException("Failed to update product"+e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> removeProductDetail(long productDetailId) {
        try{
            if (productDetailId == 0)
                return new ResponseEntity<>("Product Detail id not found",HttpStatus.BAD_REQUEST);

            Optional<ProductDetailEntity> productDetailEntity = productDetailRepository.findById(productDetailId);
            if (productDetailEntity.isEmpty())
                return new ResponseEntity<>("Product Detail not found",HttpStatus.BAD_REQUEST);

            productDetailRepository.delete(productDetailEntity.get());

            return new ResponseEntity<>("Product detail remove successful",HttpStatus.OK);

        }catch (Exception e){
            throw new CustomException("Failed to remove product detail : "+e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> removeProduct(long productId) {
        try{
            if (productId == 0)
                return new ResponseEntity<>("Product Id not found",HttpStatus.BAD_REQUEST);

            Optional<ProductEntity> productEntity = productRepository.findById(productId);
            if (productEntity.isEmpty())
                return new ResponseEntity<>("Product not found",HttpStatus.BAD_REQUEST);

            List<ProductDetailEntity> detailList = productDetailRepository.findByProductEntity(productEntity.get());
            for (ProductDetailEntity productDetailEntity :
                    detailList) {
                productDetailRepository.delete(productDetailEntity);
            }

            productRepository.delete(productEntity.get());
            return new ResponseEntity<>("Product remove successful",HttpStatus.OK);
        }catch (Exception e){
            throw new CustomException("Failed to remove product : "+e.getMessage());
        }
    }

    private ProductResponseDTO setProductResponse(ProductEntity productEntity){
        ProductResponseDTO responseDTO = modelMapper.map(productEntity, ProductResponseDTO.class);
        List<ProductDetailEntity> detailList = productDetailRepository.findByProductEntity(productEntity);
        List<ProductDetailResponseDTO> detailResponseList = new ArrayList<>();
        for (ProductDetailEntity productDetailEntity:
                detailList) {
            ProductDetailResponseDTO detailResponseDTO = modelMapper.map(productDetailEntity, ProductDetailResponseDTO.class);
            detailResponseDTO.setUpdateDate(productDetailEntity.getUpdateDate().toString());
            detailResponseDTO.setUpdateTime(productDetailEntity.getUpdateTime().toString());
            detailResponseList.add(detailResponseDTO);
        }
        CategoryResponseDTO categoryResponseDTO = modelMapper.map(productEntity.getCategoryEntity(), CategoryResponseDTO.class);
        responseDTO.setCategoryResponseDTO(categoryResponseDTO);
        responseDTO.setProductDetailList(detailResponseList);
        return responseDTO;
    }
}
