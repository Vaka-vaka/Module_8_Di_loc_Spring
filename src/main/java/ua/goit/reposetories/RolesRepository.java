package ua.goit.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.model.Producers;
import ua.goit.model.Roles;
import ua.goit.model.User;

import java.util.UUID;

@Repository
public interface RolesRepository extends JpaRepository<Roles, UUID> {

//    Roles findByFirstName(String name);
}
