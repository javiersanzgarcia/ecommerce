package com.hexagonal.ecommerce.usecase;

import com.hexagonal.ecommerce.common.PriceFormatter;
import com.hexagonal.ecommerce.common.ProductDto;
import com.hexagonal.ecommerce.domain.model.Product;
import com.hexagonal.ecommerce.domain.repository.ProductRepositoryPort;
import com.hexagonal.ecommerce.infrastructure.database.mysql.entity.ProductHexaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class ProductInteractorImpl implements IProductInteractor {

    private final ProductRepositoryPort productRepository;

    @Override
    public Product findProductById(String productId) {
        return productRepository.findProductByProductId(productId);
    }

    @Override
    public Product[] findAllProducts() {
        return productRepository.findAllProducts();
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        return productRepository.createProduct(new ProductHexaEntity(
                productDto.getProductId(),
                productDto.getName(),
                productDto.getDescription(),
                new BigDecimal(PriceFormatter.unformatPrice(productDto.getPrice())[0]),
                PriceFormatter.unformatPrice(productDto.getPrice())[1]
        ));
    }

    @Override
    public Product updateProduct(ProductDto productDto) {
        return productRepository.updateProduct(new ProductHexaEntity(
                productDto.getProductId(),
                productDto.getName(),
                productDto.getDescription(),
                new BigDecimal(PriceFormatter.unformatPrice(productDto.getPrice())[0]),
                PriceFormatter.unformatPrice(productDto.getPrice())[1]
        ));
    }

    @Override
    public void deleteProductById(String productId) {
        productRepository.deleteProductById(productId);
    }
}
