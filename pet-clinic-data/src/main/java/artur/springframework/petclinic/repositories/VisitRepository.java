package artur.springframework.petclinic.repositories;

import artur.springframework.petclinic.domain.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
