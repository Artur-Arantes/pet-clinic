package artur.springframework.petclinic.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@MappedSuperclass
@RequiredArgsConstructor
@Generated
@EqualsAndHashCode(of = "id")
@ToString
@SuperBuilder
public class Person extends BaseEntity {
  @Column(name = "first_name")
  protected String firstName;

  @Column(name = "last_name")
  protected String lastName;
}
