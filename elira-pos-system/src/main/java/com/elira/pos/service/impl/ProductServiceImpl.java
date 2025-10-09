package com.elira.pos.service.impl;

import com.elira.pos.mapper.ProductMapper;
import com.elira.pos.modal.Category;
import com.elira.pos.modal.Product;
import com.elira.pos.modal.Store;
import com.elira.pos.modal.User;
import com.elira.pos.payload.dto.ProductDTO;
import com.elira.pos.repository.CategoryRepository;
import com.elira.pos.repository.ProductRepository;
import com.elira.pos.repository.StoreRepository;
import com.elira.pos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;
    private final CategoryRepository categoryRepository;
    

    @Override
    public ProductDTO createProduct(ProductDTO productDTO, User user) {
        Store store = storeRepository.findById(
                productDTO.getStoreId()
        ).orElseThrow(
                ()->new RuntimeException("Store not found")
        );

        Category category = categoryRepository.findById(
                productDTO.getCategoryId()
        ).orElseThrow(
                ()->new RuntimeException("Category not found")
        );

        Product product= ProductMapper.toEntity(productDTO, store, category);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO, User user) {
        Product product = productRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Product not found")
        );

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setSku(productDTO.getSku());
        product.setImage(productDTO.getImage());
        product.setMrp(productDTO.getMrp());
        product.setSellingPrice(productDTO.getSellingPrice());
        product.setBrand(productDTO.getBrand());
        product.setUpdatedAt(LocalDateTime.now());

        if (productDTO.getCategoryId()!=null) {
            Category category = categoryRepository.findById(
                    productDTO.getCategoryId()
            ).orElseThrow(
                    ()->new RuntimeException("Category not found")
            );
            product.setCategory(category);
        }
        
        Product savedProduct = productRepository.save(product);

        return ProductMapper.toDTO(savedProduct);
    }

    @Override
    public void deleteProduct(Long id, User user) {

        Product product = productRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Product not found")
        );

        productRepository.delete(product);

    }

    @Override
    public List<ProductDTO> getProductsByStoreId(Long storeId) {
        List<Product> products = productRepository.findByStoreId(storeId);
        return products.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());

    }

    @Override
    public List<ProductDTO> searchByKeyword(Long storeId, String keyword) {

        List<Product> products = productRepository.searchByKeyword(storeId, keyword);
        return products.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());

    }
}
