package artur.springframework.petclinic.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Speciality extends BaseEntity{
  private String description;
}
