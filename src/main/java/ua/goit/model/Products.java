package ua.goit.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "products", uniqueConstraints = @UniqueConstraint(columnNames = "products_name"))
public class Products {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @Size(min = 5, message = "Products should be at least 5 character.")
  @Column(name = "products_name")
  private String name;

  @Column(name = "price")
  private BigDecimal price = BigDecimal.ZERO;

  @NotNull(message = "Products mast have producers!")
  @ManyToOne
  @JoinColumn(name = "producers_id", referencedColumnName = "id")
  private Producers producers;
}