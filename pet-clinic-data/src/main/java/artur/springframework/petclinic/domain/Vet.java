package artur.springframework.petclinic.domain;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vet extends Person{
  private Set<Speciality> speciality;
}
