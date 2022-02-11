package ua.goit.producers;

import lombok.*;
import ua.goit.model.Products;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

//@Entity
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode(exclude = "products")
//public class Producers implements BaseEntity<UUID>{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private UUID id;
//
//    @Column(name = "name")
//    private String name;
//
//    @OneToMany(mappedBy = "producers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @ToString.Exclude
//    private Set<Products> products;
//
//    @Override
//    public UUID getId() {
//        return id;
//    }
//
//}
