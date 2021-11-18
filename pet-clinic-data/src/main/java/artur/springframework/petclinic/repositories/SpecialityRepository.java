package artur.springframework.petclinic.repositories;

import artur.springframework.petclinic.domain.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
