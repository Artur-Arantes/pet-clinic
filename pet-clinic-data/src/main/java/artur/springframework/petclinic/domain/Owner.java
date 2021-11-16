package artur.springframework.petclinic.domain;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Owner extends Person {
  private String address;
  private String city;
  private String telephone;
  private Set<Pet> pets;
}