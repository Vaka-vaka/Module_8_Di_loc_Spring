package ua.goit.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Size(min = 3, message = "Role should be at least 3 character.")
    @Column(name = "roles_name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH},
        fetch = FetchType.EAGER)
    @JoinTable(
        name = "userS_roleS",
        joinColumns = { @JoinColumn(name = "roleS_id") },
        inverseJoinColumns = { @JoinColumn(name = "userS_id") }
    )
    private transient List<User> users;
}