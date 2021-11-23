package artur.springframework.petclinic.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "owners")
@EqualsAndHashCode(of = "id")
public class Owner extends Person {


  @Builder
  public Owner(Long id, String firstName, String lastName, String address, String city,
               String telephone, List<Pet> pets) {
    super(id, firstName, lastName);
    this.address = address;
    this.city = city;
    this.telephone = telephone;
    this.pets = pets;
  }

  @Column(name = "address")
  private String address;

  @Column(name = "city")
  private String city;

  @Column(name = "telephone")
  private String telephone;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
  private List<Pet> pets;

  public List<Pet> getPets(){
    if (Objects.isNull(this.pets)){
      this.pets=new ArrayList<>();
    }
    return this.pets;
  }
}