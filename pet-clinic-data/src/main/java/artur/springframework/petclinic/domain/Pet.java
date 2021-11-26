package artur.springframework.petclinic.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

  @Builder
  public Pet(Long id, String name, PetType petType,
             Owner owner, LocalDate birthDate,
             List<Visit> visits) {
    super(id);
    this.name = name;
    this.petType = petType;
    this.owner = owner;
    this.birthDate = birthDate;
    this.visits = visits;
  }

  @Column(name = "name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "type_id")
  private PetType petType;

  @JoinColumn(name = "owner_id")
  @ManyToOne
  private Owner owner;

  @Column(name = "birth_date")
  private LocalDate birthDate;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
  private List<Visit> visits = new ArrayList<>();

}
