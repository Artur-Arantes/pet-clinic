package artur.springframework.petclinic.services.map;

import artur.springframework.petclinic.domain.Visit;
import artur.springframework.petclinic.services.VisitServices;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitServices {

  @Override
  public List<Visit> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Visit object) {
    super.delete(object);
  }

  @Override
  public Visit save(Visit object) {
    if (object.getPet() == null || object.getPet().getOwner() == null ||
        object.getPet().getId() == null ||
        object.getPet().getOwner().getId() == null) {
      throw new RuntimeException("invalid visit");
    }
    return super.save(object);
  }

  @Override
  public Visit findById(Long id) {
    return super.findById(id);
  }
}
