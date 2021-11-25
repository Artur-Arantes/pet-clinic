package artur.springframework.petclinic.repositories;

import artur.springframework.petclinic.domain.Owner;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

  Owner findByLastName(String lastname);

  List<Owner> findAllByLastNameLike(String lastName);
}
