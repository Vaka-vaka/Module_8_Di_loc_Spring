package ua.goit.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.model.Producers;

import java.util.UUID;

@Repository
public interface ProducersRepository extends JpaRepository<Producers, UUID> {


}
