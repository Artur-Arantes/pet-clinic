package artur.springframework.petclinic.services;

import artur.springframework.petclinic.domain.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

  Owner findByLastName(String lastName);

}
