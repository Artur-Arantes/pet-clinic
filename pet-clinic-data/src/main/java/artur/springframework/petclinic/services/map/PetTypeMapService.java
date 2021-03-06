package artur.springframework.petclinic.services.map;

import artur.springframework.petclinic.domain.PetType;
import artur.springframework.petclinic.services.PetTypeService;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

  @Override
  public List<PetType> findAll() {
    return super.findAll();
  }


  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
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
