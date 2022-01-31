package ua.goit.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Email(message = "Email Address")
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "last_name")
    private String lastName;

    @Size(min = 5, message = "First name should be at least 5 character.")
    @Column(name = "first_name")
    private String firstName;

  //  @NotNull(message = "User has minimum one role!")
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "userS_roleS",
            joinColumns = { @JoinColumn(name = "userS_id") },
            inverseJoinColumns = { @JoinColumn(name = "roleS_id") }
    )
    private List<Roles> roles;



}