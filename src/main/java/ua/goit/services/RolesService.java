package ua.goit.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.dto.ProductsDto;
import ua.goit.dto.RolesDto;
import ua.goit.model.Products;
import ua.goit.model.Roles;
import ua.goit.reposetories.RolesRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RolesService {

    @Autowired
    protected RolesRepository repository;
    @Autowired
    private ModelMapper modelMapper;

//    public RolesDto getByName(String name) {
//        return modelMapper.map(repository.findByFirstName(name), RolesDto.class);
//    }

    public List<RolesDto> getAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public RolesDto get(UUID id) {
        return  repository.findById(id)
                .map(this::convertToDto)
                .orElseThrow();
    }
    private RolesDto convertToDto(Roles roles) {
        return modelMapper.map(roles, RolesDto.class);
    }
//    @Override
//    public boolean isExist(Dto dto) {
//        if (dto.getId() == null) {
//            return repository.existsByNameIgnoreCase(((RoleDto) dto).getName());
//        } else {
//            return repository.existsByNameIgnoreCaseAndIdIsNot(((RoleDto) dto).getName(), dto.getId());
//        }
//    }
}
