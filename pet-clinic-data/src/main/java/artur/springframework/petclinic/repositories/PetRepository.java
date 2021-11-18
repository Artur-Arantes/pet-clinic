package artur.springframework.petclinic.repositories;

import artur.springframework.petclinic.domain.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
