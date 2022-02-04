package ua.goit.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ua.goit.annotations.LogMe;
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
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;

    @LogMe
    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @LogMe
    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
//        var dto = new UserDto();
//        dto.setLastName(user.getLastName());
//        dto.setFirstName(user.getFirstName());
//        dto.setEmail(user.getEmail());
//        return dto;
    }

    @LogMe
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
        User user = modelMapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    public void update(UUID id, UserDto userDto) {
        userRepository.findById(id)
                .map(user -> {
                    if(StringUtils.hasText(userDto.getEmail())){
                        user.setEmail(userDto.getEmail());
                    }
                    if(StringUtils.hasText(userDto.getPassword())){
                        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
                    }
                    return user;
                }).ifPresent(user -> {
                    userRepository.save(user);
                });
    }

    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    public Object getEdit(UUID id) {
        return userRepository.findById(id);
    }
}
