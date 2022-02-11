package ua.goit.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ua.goit.dto.ProductsDto;
import ua.goit.model.Products;
import ua.goit.reposetories.ProductsRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductsService {

        @Autowired
        private ProductsRepository repository;
        @Autowired
        private ModelMapper modelMapper;

        @Cacheable(value = "categories")
        public List<Products> getAll() {
            return repository.findAll();
        }

        public List<ProductsDto> getAllDto() {
            return getAll()
                    .stream()
                    .map(this::convert)
                    .collect(Collectors.toList());
        }

        private ProductsDto convert(Products entity) {
            return modelMapper.map(entity, ProductsDto.class);
        }

        @CacheEvict(value = "categories", allEntries = true)
        public void update(ProductsDto dto) {
            System.out.println("asdasdasdasdasd");
        }

        public Products get(UUID id) {
            return repository.getById(id);
        }

    public void save(Products products) {
            repository.save(products);
    }

    public void create(ProductsDto productsDto) {
        var products = new Products();
        products.setName(productsDto.getName());
        repository.save(products);
    }

    public void update(UUID id, ProductsDto productsDto) {
        repository.findById(id)
                .map(producers -> {
                    if(StringUtils.hasText(productsDto.getName())){
                        producers.setName(productsDto.getName());
                    }
                    return producers;
                }).ifPresent(user -> {
                    repository.save(user);
                });
    }

    private ProductsDto convertToDto(Products products) {
        return modelMapper.map(products, ProductsDto.class);
    }

    public ProductsDto getDto(UUID id) {
        return  repository.findById(id)
                .map(this::convertToDto)
                .orElseThrow();
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
