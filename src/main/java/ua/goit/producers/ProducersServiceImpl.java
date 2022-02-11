package ua.goit.producers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

//@RequiredArgsConstructor
//@Service
//public class ProducersServiceImpl implements BaseService<Producers, UUID>{
//
//    @Autowired
//    private ProducersRepository producersRepository;
//
//    public List<Producers> findAll() {
//        return  producersRepository.findAll();
//    }
//
//    public Producers findById(Long id) {
//        return producersRepository.findById(id).orElse(null);
//    }
//
//    public Producers findByName(String name) {
//        return producersRepository.findByName(name).orElse(null);
//    }
//
//    public Producers save(Producers producer){
//        return producersRepository.save(producer);
//    }
//
//    public void deleteById(Long id){
//        producersRepository.deleteById(id);
//    }
//
//}
