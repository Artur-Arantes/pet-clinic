package artur.springframework.petclinic.repositories;

import artur.springframework.petclinic.domain.Vet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Vet, Long> {
}
