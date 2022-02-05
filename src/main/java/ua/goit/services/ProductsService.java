package ua.goit.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ua.goit.dto.ProductsDto;
import ua.goit.dto.UserDto;
import ua.goit.model.Products;
import ua.goit.model.User;
import ua.goit.reposetories.ProductsRepository;
import ua.goit.reposetories.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Cacheable(value = "products")
    public List<Products> getAll() {
        return productsRepository.findAll();
    }

    public List<ProductsDto> getAllDto() {
        return getAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ProductsDto convertToDto(Products products) {
        return modelMapper.map(products, ProductsDto.class);
    }

    public ProductsDto get(UUID id) {
        return  productsRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow();
    }

    public void create(ProductsDto productsDto) {
        var products = new Products();
        products.setName(productsDto.getName());
        products.setPrice(productsDto.getPrice());
        products.setProducers(productsDto.getProducers());
        productsRepository.save(products);
    }

    public void update(UUID id, ProductsDto productsDto) {
        productsRepository.findById(id)
                .map(product -> {
                    product.setProducers(null);
                    modelMapper.map(productsDto, product);
                    return product;
                }).ifPresent(product -> productsRepository.save(product));
//                .map(products -> {
//                    if(StringUtils.hasText(productsDto.getName())){
//                        products.setName(productsDto.getName());
//                    }
//                    if(StringUtils.hasText(String.valueOf((productsDto.getPrice())))){
//                        products.setPrice(productsDto.getPrice());
//                    }
//                    return products;
//                }).ifPresent(user -> {
//                    productsRepository.save(user);
//                });
    }

    public void delete(UUID id) {
        productsRepository.deleteById(id);
    }
}
