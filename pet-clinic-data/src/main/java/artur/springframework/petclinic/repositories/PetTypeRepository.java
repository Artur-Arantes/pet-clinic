package artur.springframework.petclinic.repositories;

import artur.springframework.petclinic.domain.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
