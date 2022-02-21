package ua.goit.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ua.goit.dto.ProducersDto;
import ua.goit.model.Producers;
import ua.goit.reposetories.ProducersRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProducersService {

    @Autowired
    private ProducersRepository producersRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Cacheable(value = "producers")
    public List<Producers> getAll() {
        return producersRepository.findAll();
    }

    public List<ProducersDto> getAllDto() {
        return getAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ProducersDto convertToDto(Producers producers) {
        return modelMapper.map(producers, ProducersDto.class);
    }

    public ProducersDto get(UUID id) {
        return  producersRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow();
    }

//    public void create(ProducersDto producersDto) {
//        var producers = new Producers();
//        producers.setName(producersDto.getName());
//        producersRepository.save(producers);
//    }

    @Transactional
    public void create(ProducersDto dto) {
        producersRepository.save(mapFromDto(dto));
    }

    public void update(UUID id, ProducersDto producersDto) {
        producersRepository.findById(id)
                .map(producers -> {
                    if(StringUtils.hasText(producersDto.getName())){
                        producers.setName(producersDto.getName());
                    }
                    return producers;
                }).ifPresent(user -> {
                    producersRepository.save(user);
                });
    }

    public void delete(UUID id) {
        producersRepository.deleteById(id);
    }

    private Producers mapFromDto(ProducersDto dto) {
        return modelMapper.map(dto, Producers.class);
    }

}
