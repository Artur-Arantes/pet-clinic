package artur.springframework.petclinic.services.map;

import artur.springframework.petclinic.domain.PetType;
import artur.springframework.petclinic.services.PetTypeService;
import java.util.Set;

public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

  @Override
  public Set<PetType> findAll() {
    return super.findAll();
  }


  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public PetType findByLastName(String lastname) {
    return findByLastName(lastname);
  }

  @Override
  public void delete(PetType object) {
    super.delete(object);
  }

  @Override
  public PetType save(PetType object) {
    return super.save(object);
  }

  @Override
  public PetType findById(Long id) {
    return findById(id);
  }
}