package artur.springframework.petclinic.services.map;

import artur.springframework.petclinic.domain.Pet;
import artur.springframework.petclinic.services.PetServices;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetServices {
  @Override
  public Set<Pet> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Pet object) {
    super.delete(object);
  }

  @Override
  public Pet save(Pet object) {
    return super.save(object);
  }

  @Override
  public Pet findById(Long id) {
    return super.findById(id);
  }


}
