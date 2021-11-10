package artur.springframework.petclinic.domain;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet extends BaseEntity {
  private PetType petType;
  private Owner owner;
  private LocalDate birthDate;
}
