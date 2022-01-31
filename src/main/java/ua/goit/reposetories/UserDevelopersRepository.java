package ua.goit.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ua.goit.model.User;
import ua.goit.model.UserDevelopers;

import java.util.UUID;

@Repository
public interface UserDevelopersRepository extends JpaRepository<UserDevelopers,Long> {


}
