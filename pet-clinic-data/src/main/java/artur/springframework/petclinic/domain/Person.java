package artur.springframework.petclinic.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Generated
@EqualsAndHashCode(of = "id")
public class Person extends BaseEntity {

  @Column(name = "first_name")
  protected String firstName;

  @Column(name = "last_name")
  protected String lastName;

  public Person(Long id, String firstName, String lastName) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
