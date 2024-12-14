package com.product.service.service.serviceImpl;

import com.product.service.ExceptionHandling.ResourceNotFoundException;
import com.product.service.external.CategoryClient;
import com.product.service.model.Product;
import com.product.service.model.ProductDTO;
import com.product.service.repository.ProductRepository;
import com.product.service.service.ProductService;
import com.productCategory.service.module.CategoryDto;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
     String notFound = "Category not found with ID: ";

    @Autowired
    private CategoryClient categoryClient; // FeignClient to validate category

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(notFound + id));
        return mapToDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(notFound + id));
        productRepository.delete(product);
    }
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

        logger.info("Starting product creation process for SKU: {}", productDTO.getSku());

        try {
            // Validate category existence via FeignClient
            logger.info("Fetching category with ID: {}", productDTO.getCategoryId());
            CategoryDto category = categoryClient.getCategoryById(productDTO.getCategoryId());

            if (category == null) {
                logger.error("Category with ID: {} not found.", productDTO.getCategoryId());
                throw new ResourceNotFoundException(notFound + productDTO.getCategoryId());
            }
            logger.info("Category with ID: {} found successfully.", productDTO.getCategoryId());

            // Proceed with product creation
            Product product = new Product();
            product.setName(productDTO.getName());
            product.setSku(productDTO.getSku());
            product.setPrice(productDTO.getPrice());
            product.setDescription(productDTO.getDescription());
            product.setQuantity(productDTO.getQuantity());
            product.setImageUrl(productDTO.getImageUrl());
            product.setCategoryId(productDTO.getCategoryId());
            product.setCustomerId(productDTO.getCustomerId());

            // Save product
            logger.info("Saving product with SKU: {}", productDTO.getSku());
            product = productRepository.save(product);

            logger.info("Product with SKU: {} saved successfully with ID: {}", product.getSku(), product.getId());

            // Map and return DTO
            return mapToDTO(product);

        } catch (FeignException.NotFound e) {
            logger.error("Category with ID: {} not found in Category Service.", productDTO.getCategoryId(), e);
            throw new ResourceNotFoundException(notFound + productDTO.getCategoryId());
        } catch (Exception e) {
            logger.error("Failed to create product with SKU: {}", productDTO.getSku(), e);
            throw new RuntimeException("Failed to create product: " + e.getMessage(), e);
        }
    }

    private ProductDTO mapToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setSku(product.getSku());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setImageUrl(product.getImageUrl());
        productDTO.setCategoryId(product.getCategoryId());
        productDTO.setCustomerId(product.getCustomerId());
        return productDTO;
    }
    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        // Validate product existence
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(notFound + id));

        // Validate category ID using FeignClient
        CategoryDto categoryExists = categoryClient.getCategoryById(productDTO.getCategoryId());
        if (categoryExists == null) {
            throw new ResourceNotFoundException(notFound+ productDTO.getCategoryId());
        }
        // Update product fields
        product.setName(productDTO.getName());
        product.setSku(productDTO.getSku());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setQuantity(productDTO.getQuantity());
        product.setImageUrl(productDTO.getImageUrl());
        product.setCategoryId(productDTO.getCategoryId());
        product.setCustomerId(productDTO.getCustomerId());
        // Save updated product and return DTO
        return mapToDTO(productRepository.save(product));
    }



}
