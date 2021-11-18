package artur.springframework.petclinic.services.map;

import artur.springframework.petclinic.domain.Speciality;
import artur.springframework.petclinic.services.SpecialitiesService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long>
    implements SpecialitiesService {


  @Override
  public Set<Speciality> findAll() {
    return super.findAll();
  }

  @Override
  public Speciality findByLastName(String lastname) {
    return null;
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Speciality object) {
    super.delete(object);
  }

  @Override
  public Speciality save(Speciality object) {
    return super.save(object);
  }

  @Override
  public Speciality findById(Long id) {
    return null;
  }
}
