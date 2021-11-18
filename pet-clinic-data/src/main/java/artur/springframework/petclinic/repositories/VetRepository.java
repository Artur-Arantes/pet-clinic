package artur.springframework.petclinic.repositories;

import artur.springframework.petclinic.domain.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
