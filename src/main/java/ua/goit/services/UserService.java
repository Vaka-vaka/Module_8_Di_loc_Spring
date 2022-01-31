package ua.goit.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.dto.UserDto;
import ua.goit.model.User;
import ua.goit.reposetories.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
//        var dto = new UserDto();
//        dto.setLastName(user.getLastName());
//        dto.setFirstName(user.getFirstName());
//        dto.setEmail(user.getEmail());
//        return dto;
    }

    public UserDto get(UUID id) {
        return  userRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow();
    }

    public void create(UserDto userDto) {
//        var user = new User();
//        user.setEmail(userDto.getEmail());
//        user.setPassword(user.getPassword());
//        user.setLastName(userDto.getLastName());
//        user.setFirstName(userDto.getFirstName());
//        userRepository.save(user);
        userRepository.save(
                modelMapper.map(userDto, User.class));
    }

    public void update(UUID id, UserDto userDto) {
        userRepository.findById(id)
                .map(user -> {
                    user.setEmail(userDto.getEmail());
                    user.setPassword(userDto.getPassword());
                    user.setLastName(userDto.getLastName());
                    user.setFirstName(userDto.getFirstName());
                    return user;
                }).ifPresent(user -> {
                    userRepository.save(user);
                });
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
