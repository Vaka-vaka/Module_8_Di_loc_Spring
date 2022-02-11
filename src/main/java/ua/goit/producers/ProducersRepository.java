package ua.goit.producers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

//public interface ProducersRepository extends JpaRepository<Producers, UUID> {
//
//    @Query("SELECT p FROM Producer p WHERE p.name=?1")
//    Optional<Producers> findByName(String name);
//
//    Optional<Producers> findById(Long id);
//
//    void deleteById(Long id);
//}
