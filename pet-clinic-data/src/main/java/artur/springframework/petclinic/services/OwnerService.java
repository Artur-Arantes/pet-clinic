package artur.springframework.petclinic.services;

import artur.springframework.petclinic.domain.Owner;
import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);

  List<Owner> findAllByLastNameLike(String lastname);


}
