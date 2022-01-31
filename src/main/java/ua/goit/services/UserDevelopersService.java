package ua.goit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.goit.model.UserDevelopers;
import ua.goit.reposetories.UserDevelopersRepository;

import java.util.List;

@Service
public class UserDevelopersService {

    @Autowired
    private UserDevelopersRepository developersRepository;

    public List<UserDevelopers> getAll() {
        return developersRepository.findAll();
    }



}
