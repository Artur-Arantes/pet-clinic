package artur.springframework.petclinic.repositories;

import artur.springframework.petclinic.domain.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
