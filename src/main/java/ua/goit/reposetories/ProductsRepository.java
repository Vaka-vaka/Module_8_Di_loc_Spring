package ua.goit.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.model.Products;
import ua.goit.model.User;

import java.util.UUID;

@Repository
public interface ProductsRepository extends JpaRepository<Products, UUID> {
    //    Products findByFirstName(String name);

}
